(ns working-with-kafka.consumeroffset
  (:require [clojure.core.async :as a]
            [ketu.clients.consumer :as c]
            [ketu.async.source :as source]
            [ketu.async.sink :as sink]
            [ketu.clients.consumer :as consumer])
  (:import (java.time Duration)
           (org.apache.kafka.clients.consumer Consumer)
           (org.apache.kafka.common.errors WakeupException)
           (org.apache.kafka.common.serialization Deserializer)))


;; Consumer Configuration:
;; https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html(


(defn -main []
  (let [topic (a/chan 10)
        source-opts {:name "greeter-consumer"
                     :brokers "localhost:9094"
                     :topic "test-topic"
                     :group-id "j13"
                     :ketu.apache.consumer/auto-offset-reset "earliest"
                     :internal-config {"enable.auto.commit" "false"
                                       "auto.offset.reset" "earliest"}
                     :value-type :string
                     :shape :value}
        source (source/source topic source-opts)]
    
    (loop []
      (let [[value, _] (a/alts!! [(a/timeout 4000) topic])]
        (cond
          (nil? value) nil
          :else (do
                  (prn value)
                  (recur)))))))
    

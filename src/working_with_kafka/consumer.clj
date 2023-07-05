(ns working-with-kafka.consumer
  (:require [clojure.core.async :as a]
            [ketu.clients.consumer :as c]
            [ketu.async.source :as source]
            [ketu.async.sink :as sink]))

(defn -main []
  (let [topic (a/chan 10)
        source-opts {:name "greeter-consumer"
                     :brokers "localhost:9094"
                     :topic "test-topic"
                     :group-id "h"
                     :value-type :string
                     :shape :value}
        source (source/source topic source-opts)]
    (loop [x (a/<!! topic)]
      (prn x)
      (recur (a/<!! topic)))))


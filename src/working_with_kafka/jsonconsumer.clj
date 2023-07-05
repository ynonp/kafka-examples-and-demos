(ns working-with-kafka.jsonconsumer
  (:require [clojure.core.async :as a]
            [ketu.async.source :as source]
            [cheshire.core :as d]
            [ketu.async.sink :as sink]))

(defn -main []
  (let [topic (a/chan 10)
        source-opts {:name "greeter-consumer"
                     :brokers "localhost:9094"
                     :topic "test-json"
                     :group-id "greeter"
                     :value-type :string
                     :shape :value}
        source (source/source topic source-opts)]
    (loop [x (a/<!! topic)]
      (prn (d/parse-string x))
      (recur (a/<!! topic)))))


(ns working-with-kafka.jsonproducer
  (:require [clojure.core.async :as a]
            [cheshire.core :as d]
            [ketu.async.sink :as sink]))

(defn -main []
  (let [topic (a/chan 10)
        sink-opts {:name "producer"
                   :brokers "localhost:9094"
                   :topic "test-json"
                   :value-type :string
                   :shape :value}
        sink (sink/sink topic sink-opts)]

  ;; Consume a name and produce a greeting. You could also do this with e.g. clojure.core.async/pipeline.
    (a/>!! topic (d/generate-string {:value (str (rand 100))}))
    (Thread/sleep 1000)

  ;; Close the sink channel `>greets`. It causes the sink to close itself as a consequence.
    (a/close! topic)))
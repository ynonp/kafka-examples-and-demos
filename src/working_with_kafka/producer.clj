(ns working-with-kafka.producer
  (:require [clojure.core.async :as a] 
           [ketu.async.sink :as sink]))

(defn -main []
  (let [topic (a/chan 10)
        sink-opts {:name "producer"
                   :brokers "localhost:9094"
                   :topic "test-topic"
                   :value-type :string
                   :shape :value}
        sink (sink/sink topic sink-opts)]

  ;; Consume a name and produce a greeting. You could also do this with e.g. clojure.core.async/pipeline.
    (a/>!! topic (str (rand 100)))
    (Thread/sleep 1000)

  ;; Close the sink channel `>greets`. It causes the sink to close itself as a consequence.
    (a/close! topic)))
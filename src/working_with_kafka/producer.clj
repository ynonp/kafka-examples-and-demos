(ns working-with-kafka.producer
  (:require [clojure.core.async :as a] 
           [ketu.async.sink :as sink]))


;;;
;;; Create topics "names", "messages", "longnames"
;;; Names should begin with a capital case and be only one word
;;; Create another topic with only names longer than 10 characters (because they are too long)
;;;
;;; 1. Write a clojure function that returns a random name (from a list of names you can think of, or just completely random)
;;; 2. Write the names to a kafka topic in a loop, sleep 5 seconds after each name
;;; 3. Read names from the loop, if they are valid then write them to a second topic (messages) with prefix "Welcome ...."
;;; 4. If the names are longer than 10 characters, write them to a third topic "longnames" so we'll notify their owners







(defn -main []
  (let [topic (a/chan 10)
        sink-opts {:name "producer"
                   :brokers "localhost:9094"
                   :topic "test-topic"
                   :value-type :string
                   :shape :value}
        sink (sink/sink topic sink-opts)]

    (a/>!! topic (str (rand 100)))
    (Thread/sleep 1000)

    (a/close! topic)))
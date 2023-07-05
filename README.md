# Hello Kafka

## A Short Overview
Image:
https://www.cloudkarafka.com/blog/part1-kafka-for-beginners-what-is-apache-kafka.html

[X] Brokers
[X] Topics
[X] Partitions
[X] Cluster (multiple brokers)
[X] Zookeeper

## Run kafka in docker and use the CLI producer/consumer
[X] Start a kafka broker (with zookeeper)
docker run -d -p 9092:9092 -p 9094:9094 -p 2182:2182 -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093,EXTERNAL://:9094 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092,EXTERNAL://localhost:9094 -e KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT,PLAINTEXT:PLAINTEXT -e KAFKA_ZOOKEEPER_USER=zk -e KAFKA_ZOOKEEPER_PASSWORD=zk --rm bitnami/kafka:latest

[X] Connect, list topics, create topic
[X] Connect to kafka from external host
[X] Produce messages in topics
[X] Consume messages in topics

----


## Add Kafka To a Leinigen Project
[ ] clojar [clj-kafka "0.3.4"]
[ ] [org.clojure/clojure "1.10.3"]
[ ] [cheshire "5.11.0"]
[ ] [org.apache.kafka/kafka-clients "2.8.0"]
[ ] [com.appsflyer/ketu "1.0.0"]
[ ] create a simple string producer
[ ] create a simple string consumer
[ ] create a JSON producer/consumer


## Random number Consumer/Producer with Kafka

- Create a Kafka producer that sends random numbers between 0 and 100 to a topic named "numbers"
- Create a consumer that prints these numbers
- Create a consumer that prints only even numbers
- Create a consumer that prints the sum of all numbers in the topic. This consumer should exit immediately after printing. Every time it is executed it prints the sum total of all numbers from the beginning of the topic.

## File Watcher and Processor

Develop a producer that monitors a specific directory for new files and sends the file contents to a Kafka topic. 
Implement a consumer that processes the file contents, searches for the string "kafka" in the file and prints out any line
that contains the word "kafka"

Hint: use clojure-watch

## Sensor Data Alerting System

Build a producer that generates simulated sensor data and sends it to a Kafka topic.
Implement a consumer that monitors the data and triggers alerts for readings above or below certain thresholds.


## Chatroom Application
Part 1
    - Producer: CLI application that takes a string and send it to the main chat room. 
    - Consumer: CLI application that shows all the messages in the main chat room.
Part 2
	- Allow both consumer and producer to accept room name. 
	- Consumers print only messages from their rooms.

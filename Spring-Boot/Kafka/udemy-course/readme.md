# Readme

## Main concepts

- Topic is an Entity in Kafka with a name
- Partition is where the message lives inside the topic
- Each topic will be created with one or more partitions
- Each partition is an ordered, immutable sequence of records
- Each record is assigned a sequential number called offset
- Each partition is independent of each other
- Ordering is guaranteed only at the partition level
- Partition continuously grows as new records are produced
- All the records are persisted in a commit log in the file system where Kafka is installed
- Kafka messages sent from producer have two properties: Key (optional) and value
- The key hash is used to define the partition that the message will be posted on. With this configuration, you can programmatically set to with partition your message will go.
- Consumer have three options to read messages: from the beggining, the latest messages, or defining a specific offset
- Consumer offsets behaves like a bookmark for the consumer to start reading the messages from the point it left of
- Consumer groups. Every group has a group id. The group id allows you to scale the number of consumers to match the number of partitions in your topic, if needed.
- Consumer groups are used for scalable message consumption
- Each different application will have a unique consumer group
- Kafka manages the consumer groups
- The retention policy is configured using the property log.retention.hours in the server.properties file
- Default retention period is  168 hours (7 days)
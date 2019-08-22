# SpringBoot RabbitMQ Producer
##Overview
[RabbitMQ](https://www.rabbitmq.com/) is an open source message broker software written in [Erlang](https://www.erlang.org/) that implements the Advanced Message Queuing Protocol ([AMQP](https://www.amqp.org/)).

This code provides a example on how to submit a message to a RabbitMQ queue.

##Prerequisites
A [RabbitMQ Docker](https://hub.docker.com/_/rabbitmq) image running locally.
See also [Docker network settings](https://docs.docker.com/engine/reference/run/#network-settings)

The following command will start a RabbitMQ container listening on the default port of 5672.

```
sudo docker run -d --network="host" rabbitmq:3-management
```


##Demo
Producer Java application sending a message with a new employee name and id to a queue.

1. Download the code for [sb_rabbitmq_producer](https://github.com/silvano-squizzato/sb_rabbitmq_producer)

2. Build the project.
```
mvn clean install
```
3. Run the producer app.
```
java -jar target/rabbitmq-producer-*.jar
```
4. Send a new employee details to a company queue.
```
http://localhost:8080/demo/producer?name=John&id=11
```
The JSON representation of an employee is the following.
```
{ 
   "id":"11",
   "name":"John"
}
```
5. Check the queue status on RabbitMQ.
```
http://localhost:15672/#/queues/%2F/company.queue
```

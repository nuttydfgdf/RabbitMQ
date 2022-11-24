https://registry.hub.docker.com/_/rabbitmq/
https://www.cloudamqp.com/blog/part1-rabbitmq-for-beginners-what-is-rabbitmq.html

Create RabbitMQ container
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 \
-e RABBITMQ_NODENAME=rabbitmq \
-e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password \
rabbitmq:3.11-management
```

Go to http://localhost:15672/
Log in with the default user/password you used when launching docker run command





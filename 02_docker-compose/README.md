
cd 02_docker-compose

```js
docker-compose up -d
```

View process
```js
docker-compose ps
```
Output(do not copy)
```console
  Name                Command               State                                                                        Ports
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
rabbitmq   docker-entrypoint.sh rabbi ...   Up      15671/tcp, 0.0.0.0:15672->15672/tcp,:::15672->15672/tcp, 15691/tcp, 15692/tcp, 25672/tcp, 4369/tcp, 5671/tcp,
                                                    0.0.0.0:5672->5672/tcp,:::5672->5672/tcp
```


View logging 
```js
docker-compose logs
```

If you want to stop executing the command below:
```js
docker-compose down
```




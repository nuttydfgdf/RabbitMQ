# Tutorial Load Testing Your API with Postman
https://k6.io/blog/load-testing-with-postman-collections/

### Reference:
https://learning.postman.com/docs/writing-scripts/script-references/variables-list/


## Using postman-to-k6
https://github.com/apideck-libraries/postman-to-k6

To convert an exported collection to a k6 script:
```
postman-to-k6 RabbitMQ.postman_collection.json -o k6-script.js
```

> Issue, 
```
    headers: {
      "Content-Type": "application/json",
    },
```

Then run the script in k6, as usual, using:
```
k6 run k6-script.js
```

cd postman-k6

run the script with option

```
k6 --duration 15s --vus 5 run k6-script.js
k6 --duration 1m --vus 10 run k6-script.js
```
> See detail at https://k6.io/docs/using-k6/k6-options/reference/#duration





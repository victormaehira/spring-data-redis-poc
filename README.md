```
curl -s http://localhost:8080/cidadao \
 -H "Content-Type: application/json" \
 -d '{"idn": "123", "psbioName": "Griaule"}'

curl -s http://localhost:8080/cidadao \
 -H "Content-Type: application/json" \
 -d '{"idn": "321", "psbioName": "Certibio"}'

curl -s http://localhost:8080/cidadao \
 -H "Content-Type: application/json" \
 -d '{"idn": "456", "psbioName": ""}'

curl -s http://localhost:8080/cidadao \
 -H "Content-Type: application/json" \
 -d '{"idn": "789", "psbioName": "Bry"}'
```
 
``` 
curl -s http://localhost:8080/cidadao/
```

```
curl -s -X PUT http://localhost:8080/cidadao \
 -H "Content-Type: application/json" \
 -d '{"idn": "1010", "psbioName": "Griaule"}'
```


```
curl -s http://localhost:8080/cidadao/123
```
```
curl -s -X DELETE http://localhost:8080/cidadao/123 
```
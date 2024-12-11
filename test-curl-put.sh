chmod +x test-curl-put.sh
curl -X PUT localhost:8080/api/persons/2 -H 'Content-type:application/json' -d '{"name": "testi testiii"}'
chmod +x test-curl-post.sh
curl -X POST localhost:8080/api/persons -H 'Content-type:application/json' -d '{"name": "testi testiii"}'
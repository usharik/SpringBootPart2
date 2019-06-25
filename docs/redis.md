# Running Spring boot web app with Redis as a Session storage

* all classes which are stored in Redis Session should implements Serializable interface
* run this command in project root directory to run Redis server with docker-compose
`docker-compose up -d`
* you can access the Redis console with command
`docker exec -it geek-market-ui_redis_1 redis-cli`
* use `KEYS` command in redis console to get all keys in DB
* use `TYPE <key>` command to get the type of sotred value
* use `GET <key>` for string, `HGETALL <key>` for hash, `SMEMBERS <KEY>` for set
FROM openjdk:8-jdk-alpine

COPY ./target/geek-market-ui-0.0.1-SNAPSHOT.jar /bin

# 'host.docker.internal' could be used to access docker host OS 'localhost'
ENV MYSQL_HOST=host.docker.internal
ENV REDIS_HOST=host.docker.internal

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/bin/geek-market-ui-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081

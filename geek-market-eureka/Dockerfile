FROM openjdk:8-jdk-alpine

COPY ./target/geek-market-eureka-0.0.1-SNAPSHOT.jar /bin

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/bin/geek-market-eureka-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761
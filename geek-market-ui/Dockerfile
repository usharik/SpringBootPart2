FROM openjdk:8-jdk-alpine

ARG JAR_FILE

COPY ./target/${JAR_FILE} /bin/app.jar
COPY ./entrypoint.sh /bin/entrypoint.sh

CMD ["/bin/entrypoint.sh"]

EXPOSE 8081

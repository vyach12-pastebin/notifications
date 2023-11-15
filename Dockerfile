FROM openjdk:17-jdk-alpine
WORKDIR /pastebin/notifications-service
COPY target/pastebin-notifications-service.jar pastebin-notifications-service.jar

RUN pwd
RUN ls

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "./pastebin-notifications-service.jar"]

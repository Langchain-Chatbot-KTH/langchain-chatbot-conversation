FROM eclipse-temurin:17
VOLUME /tmp
ARG JAR_FILE=target/swebot-chatbot-conversation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
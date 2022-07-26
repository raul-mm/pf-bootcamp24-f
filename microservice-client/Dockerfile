FROM openjdk:11
VOLUME /tmp
ADD ./target/microservice-client-0.0.1-SNAPSHOT.jar microservice-client.jar
ENTRYPOINT ["java", "-jar", "/microservice-client.jar"]
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY . .

RUN ./mvnw package


FROM eclipse-temurin:17-jre

ENV SERVER_PORT=8083

ENV FILM_MICROSERVICE_URL="http://localhost:8081"
ENV FILM_REPOSITORY_MICROSERVICE_URL="http://localhost:8082"

EXPOSE 8083

COPY --from=builder app/target/gateway.jar /app/gateway.jar

CMD ["java", "-jar", "/app/gateway.jar"]
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY . .

RUN ./mvnw package -DskipTests


FROM eclipse-temurin:17-jre

ENV SERVER_PORT=8082

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-character
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV FILM_MICROSERVICE_URL="http://localhost:8081"

EXPOSE 8082

COPY --from=builder app/target/aui_lab_repository.jar /app/film-repository.jar

CMD ["java", "-jar", "/app/film-repository.jar"]
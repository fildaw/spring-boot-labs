FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY . .

RUN ./mvnw package


FROM eclipse-temurin:17-jre

ENV SERVER_PORT=8081

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-character
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8081

COPY --from=builder app/target/aui_lab.jar /app/film.jar

CMD ["java", "-jar", "/app/film.jar"]
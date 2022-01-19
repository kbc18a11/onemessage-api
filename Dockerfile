FROM openjdk:11
COPY ./api /api
WORKDIR /api
ENTRYPOINT ["./mvnw","spring-boot:run"]

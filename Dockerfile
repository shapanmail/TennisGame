FROM maven:3.5-jdk-8-alpine
WORKDIR /app
ADD . /app
RUN mvn test
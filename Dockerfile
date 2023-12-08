FROM maven:eclipse-temurin AS MAVEN_BUILD

COPY io/pom.xml /build/
COPY io/src /build/src/

WORKDIR /build/
RUN mvn package 

FROM openjdk:17-ea-11-jdk-oraclelinux8

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/

ENTRYPOINT ["tail", "-jar", "*.jar"]

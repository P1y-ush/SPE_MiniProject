FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/scientific-calculator-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

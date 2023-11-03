FROM maven:3.8.3-openjdk-17-slim

ENV PROJECT_HOME /usr/src/ninus-api
ENV JAR_NAME rest.api-0.0.1-SNAPSHOT.jar

RUN mkdir -p ${PROJECT_HOME}
WORKDIR ${PROJECT_HOME}

COPY . .

RUN mvn clean package -DskipTests

RUN mv ${PROJECT_HOME}/target/${JAR_HOME} ${PROJECT_HOME}/

ENTRYPOINT ["java", "-jar", "${JAR_NAME}"]
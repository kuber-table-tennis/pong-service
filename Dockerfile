# Use maven to compile the java application.
FROM maven:3.9.3-amazoncorretto-17 AS build

# Set the working directory to /app
WORKDIR /workspace/app

# copy project content
COPY . ./

# Compile the application.
RUN mvn clean package -DskipTests -Dspring.profiles.active=docker -Pdocker

# Unpack the fatjar to create application layers
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Build runtime image.
FROM openjdk:17-alpine

VOLUME /tmp

# Copy the application layers
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Starts java app from the entrypoint
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.falcon.pong.service.PongServiceApplication"]
# The version of Java
FROM openjdk:11

# the working directory of the docker container
WORKDIR /app

# Copying the jar file of the project in the container directory
# COPY ./target/banking-microservices-0.0.1-SNAPSHOT.jar /app
COPY ./target/banking-microservices-0.0.1-SNAPSHOT.jar /app

# Exposing the port number of the application
EXPOSE 8761

# Setting the command to run the application
CMD ["java", "-jar", "banking-microservices-0.0.1-SNAPSHOT.jar"]
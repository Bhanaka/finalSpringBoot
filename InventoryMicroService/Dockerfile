#step 1 : use an official java rum time as the base image .
FROM maven:3.6.3-openjdk-17-slim
ARG VERSION=1.0-SNAPSHOT

#step 2 : set the working directory inside the container
WORKDIR /app

#step 3 : copy the jar file from the target folder to the working directory
COPY target/InventoryMicroService-1.0-SNAPSHOT.jar InventoryMicroService-1.0-SNAPSHOT.jar

#step 4 : expose the port your application will run on
EXPOSE  :8082

#STEP 5 : specify the command to run the application
ENTRYPOINT ["java" , "-jar" , "InventoryMicroService-1.0-SNAPSHOT.jar"]


#FROM openjdk:17-jre-slim
#WORKDIR /app/
#
#COPY --from=builder /build/target/application.jar /app/
#CMD java -jar /app/application.jar
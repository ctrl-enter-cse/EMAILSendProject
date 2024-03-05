#FROM maven:3.8.3-openjdk-17 As build
#COPY . .
#RUN mvn clean package -DskipTests

#FROM openjdk:17-jdk-slim
#COPY --from=build /target/mailsendproject-0.0.1-SANPSHOT.jar mailsendproject.jar
#EXPOSE  8081
#ENTRYPOINT [ "java","-jar","/mailsendproject.jar" ]

FROM openjdk:17
COPY . .
RUN mvn clean package -DskipTests
LABEL maintainer ="crt-enter-cse"
ADD target/mailSenderProject.jar mailSenderProject.jar
ENTRYPOINT ["java","-jar","mailSenderProject.jar"]
# Maven
#FROM maven:3-jdk-11
#WORKDIR /incidisfy-backend-reclamacao
#COPY . .
#RUN mvn clean install
#CMD mvn spring-boot:run

FROM maven:3-jdk-11
VOLUME /tpm
ADD /target/*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
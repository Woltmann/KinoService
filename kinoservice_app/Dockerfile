FROM gradle:8.4-jdk17
COPY . /home/gradle/project
WORKDIR /home/gradle/project
RUN chmod +x gradlew
RUN ./gradlew build
CMD java -jar ./app/build/libs/app.jar
# Proof of Concepts

## Description
We have three PoC in this project:
1. PoC to use Spring framework to handle REST Services.
2. PoC in Java language to find students that is inside a course using their geolocation.
3. PoC in Python language to find students that at least two are inside the same class using their geolocation. 

## Author
  - Antonio Mamani - antonio.mq@gmail.com

---

### PoC Spring
PoC to create Rest Services using the [Spring Framework](https://spring.io) and Java 8

#### Dependency
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [maven](https://maven.apache.org/)

#### Run Project Spring
1. compile the project
```shell
mvn compile
```

2. generate Jar 
```
mvn package
```

3. run project
```
java -jar target/course-api-0.0.1-SNAPSHOT.jar
```

4. Open your favorite browser and open the following url : ``http://localhost:8080/``
5. To see documentation open the file ``rest-documentation.ymal`` in http://editor.swagger.io/

---

### PoC Java
The format printed is not the same from the examples, but the answer is the same that we want

#### Run project Java
Import the project in IDE that you want and execute the class Main also you can run the UnitTest in the project

---

### PoC Python
The script main.py call the method ``exampleSimulationOne`` that calls all methods to simulate ``studentClustersInClasses``

#### Dependency
* Python 2.7.6

#### Run project Python
To run project enter to the directory ``student-geolocation-python`` then run the following command in terminal:
```shell
python main.py
```



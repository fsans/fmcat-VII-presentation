### WS-P1 Springboot REST service

[![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/fsans/fmcat-VII-presentation/blob/master/LICENSE.txt)

*Barcelona. Saturday NOV 17 2018. By Francesc Sans*


Spring Boot app with REST API demo, using the following frameworks:

- Java 8
- SpringBoot
- JPA & Hibernate
- H2 & MySQL
- Maven 
    
#### 1 Create a new Spring Boot starter app

##### 1.1 Using springboot CLI:
   
```bash
spring init -n=springboot -d=web,jpa,mysql,devtools --package-name=com.fmcat springboot
```
the project is generated to **./demo** folder, open the terminal and cd into it
        
##### 1.2 Using spring.io starter utility:
Go to http://start.spring.io (explain )

- set package to:  com.fmcat
- set name to: springboot
- add dependencies:  web  jpa  mysql  devtools
- generate project (...the project is downloaded)
- open terminal and go to the generated folder (unzip downloaded file)

Open with the code IDE (**Intellij Idea**):
```bash
idea pom.xml
``` 
> Explain what is a Maven project and how it is self configured, loaded and built.

#### 2 Create a new database in MySQL

Create a new database using your IDE of choice (**Sequel Pro**):
    
    name: springboot
    user: admin
    pwd: wakawaka
 
```sql
 CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext NOT NULL,
  `description` varchar(250) NOT NULL,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
```
   


    
#### 3 Setup Spring application properties

Edit src/main/resources/application.properties

Add database details and hibernate preferences for a MySQL system
    
```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false
    spring.datasource.username=admin
    spring.datasource.password=wakawaka
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.hibernate.ddl-auto = update
    logging.level.org.hibernate.SQL=DEBUG
    logging.level.org.hibernate.type=TRACE
```
#### 4 Repeat step 2 with FileMaker

Open FileMaker v16/17 and connect to server @ remoto.codroper.com (database FMCat)

Create a database with same fields as in the example with MySQL.

In the IDE setup a JDBC connection. Explain the following points:

- Connection setup: jdbc:filemaker://remoto.codroper.com:2399/FMCat?useSSL=false
- Create a JDBC driver adding fmjdbc.jar
- Setup the connection and testing

Review the interaction with the databases from the IDE


Setup the Spring properties for FileMaker:

NOTE: instructions to use FileMakerDialect [**here**](https://gist.github.com/fsans/6902c696471502f8e52b853822730fc1)

```properties
spring.datasource.driver-class-name=com.filemaker.jdbc.Driver
spring.datasource.url=jdbc:filemaker://remoto.codroper.com/FMCat?useSSL=false
spring.datasource.username=admin
spring.datasource.password=wakawaka
spring.jpa.properties.hibernate.dialect = nl.keates.filemaker.hibernate.dialect.FileMakerDialect
spring.datasource.hikari.connection-test-query=SELECT p.* FROM FileMaker_Tables p
``` 
Explain why spring.jpa.hibernate.ddl-auto=none because FileMaker SQL support sucks.


    
#### 4 Create entities
Will design a Post-Comments applicaction, so start with the Post and Comment objects

First create the following Entities writing the basic code:


```java
package com.fmcat;

public class Post {

    private Long id;
    private String content;
    private String title;
    private Long authorId;
 }
    
```
Add setters and getters... (autogenerate with IDE support)

Add JPA/Hibernate anotations:

```java
package com.fmcat;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {

    private Long id;
    private String content;
    private String title;
    private Long authorId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    ...
    
    @Column(name = "content")
    ...
 }
    
```

Add hash and equality metods... (autogenerate with IDE support)

Then show how to generate entities from tables using JPA/Hibernate.

Once the entities are generated, lets cretae a REST Service.

Create the **Repository**
This will handle all the interaction with the database.
Explain the injection of Spring **@Repository**.

```java
package com.fmcat;

    import com.fmcat.Post;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {

}
```
Explain JpaRepository and what it provides (all the code to handle database interaction, no SQL editing).

Create the **Controller**
This is the endpoint to the HTTP REST connections (REST gateway). Explain the injection Spring **@RestController**.

```java
package com.fmcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public Page<Post> getAllPost(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}
```
Run from the IDE, review the generated database, add a new get mapping to check

Add all the handlers in the controller

```java
@PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
    
```

Add the Custom Error Handler

```java
package com.fmcat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

#### 5 Start the app and test the REST API

In the IDE clic on run and then open:

http://localhost:8080 to test http service.

http://localhost:8080/posts to test rest GET API.

Open Postman and enter test all the API entry points (GET, POST, PUT and DELETE)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a3207c331f3d2c79d864)



Now we have a (free, open sourced) FileMaker ODBC integration with Java, Spring, JPS, Hibernate and a Custom REST API and will use it to crete NodeJS+Angular applications



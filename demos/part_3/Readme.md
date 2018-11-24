### WS-P3 Generating a full stack Spring,Hibernate,ODBC,NodeJS, Angular application
*Barcelona. Saturday NOV 17 2018. By Francesc Sans*

Full stack app generation using JHipster


### 1 Install JHipster

```bash
npm install -g npm

## only if Marketplace is required
npm install -g yo

npm install -g generator-jhipster
```
Other requirements: Maven, Hava8, Git, 


to create a new app:

```bash
jhipster

## once finished, build with 
./mvnw

```
in other terminal start it:

(Note thta this will publish the app wiyt **Webpack**)
```bash
npm start
```

is also posible to dev using ng

```bash
ng serve
```

#### Generating the entities

open JHipster studio:

https://start.jhipster.tech/jdl-studio/




example:
```javascript
entity Post {
    title String required,
    content TextBlob required,
    author User
}

entity Comment {
    content TextBlob required,
    author User,
    post Post
}

entity User {
    name String required,
    email String required
}

relationship ManyToOne {
    Post{author} to User,
    Comment{post} to Post,
    Comment{author} to User
}

search Post, Comment with ElasticSearch
paginate * with infinite-scroll
```


to update the schema and all the app:
```bash
jhipster import-jdl ./my-jdl-file.jdl
```
If you want to use a much more advanced schema or UML IDE, try it...

Open **DBSchema** and generate databases


#### Testing

using **Protractor**

### 2 Deploying standalone

generate Jar Executable 

### 3 Deploying on existing app servers

generate WAR file

### 4 Deploying to the cloud

Will use **Heroku** because it's full integrated with the tech stack used by JHipster, is free, and is maybe the easiest way I know right now.

First login to heroku, the just run the jhipsetr integrated deployer:

```bash
heroku login

jhipster 


```

### 4 End

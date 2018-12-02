### WS-P2 NodeJS Backend & Angular Frontend

[![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/fsans/fmcat-VII-presentation/blob/master/LICENSE.txt)

*Barcelona. Saturday NOV 17 2018. By Francesc Sans*


Javascript approach for Server & Client demo, using the following frameworks and applications:

- NodeJS
- Angular
- FileMaker Server
- Postman


### 1 Creating a basic HTTP server with NodeJS

Verify if npm is installed, install NodeJS or Update to required version:

```bash
npm --version
node --version
brew install nodejs
npm --version

```

Create the app folder and the main file **myApp.js**

```bash
take ~/Desktop/fmc-demo/part_2
stt myApp.js
```

write the app **myApp.js**:



```ts
const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World\n');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
```

Start the app **myApp.js**

> node myApp.js


Open the app with the browser at the configured host:port http://localhost:3000



### 2 Modules

Create a simple module **getDate.js**

```ts
exports.myDateTime = function () {
    return Date();
};
```
add the function to our app **myApp.js**

```ts
const http = require('http');
const dt = require('./getDate');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.write("The date and time are currently: " + dt.myDateTime());
  res.end('');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});

```
The basic: FileSystem. Create a new HTML page

```HTML
<html>
    <body>
        <h1>Hello</h1>
        <p>This is my HTML page</p>
    </body>
</html>

```
And update our app **myApp.js**

```ts
const http = require('http');
const fs = require('fs');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  fs.readFile('index.html', function(err, data) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(data);
    res.end();
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
```

More advanced server that allows passing which file to open...

Create a minimalist HTML page

```HTML
<html>
    <body>
        <h1>Hello</h1>
        <p>This is my HTML page</p>
    </body>
</html>

```
Now add a url parser and load the page on demand (parse the url and get the page file)

```javascript
const http = require('http');
const url = require('url');
const fs = require('fs');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer(function (req, res) {
  var q = url.parse(req.url, true);
  var filename = "." + q.pathname;
  fs.readFile(filename, function(err, data) {
    if (err) {
      res.writeHead(404, {'Content-Type': 'text/html'});
      return res.end("404 Not Found");
    }  
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(data);
    return res.end();
  });
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
```

Now we can create additional static pages and serve it dynamically *==(demo)==*, but we still need to merge it with live data and off course malke much more complex front end pages.

Here comes UI Frameworks like Angulas, Rest, Vue and others.

### 3 Generating complex front ends

NOTE: from now using angular 7 !!!

Explain what is Angular and angular cli



```bash
npm install -g @angular/cli
ng

```
Basic node/angular app, named **myapp**

```bash
take ~/Desktop/fmc-demo/part_2
ng new myapp
cd myapp
ng serve -o
```
Review the output messages

Check it out in the browser at http://localhost:4200 

From now move to vscode
```bash
code .
```
Create modules NV, HOME and POST

```bash
ng generate component nav
ng generate component home
ng generate component posts
```

open the Terminal view in vscode and crete the new components

change the **app.component.html** to 
```html
<app-nav></app-nav>
<section>
  <router-outlet></router-outlet>
</section>
```


Create a basic home page in **home.component.html**

```html
<h1>Home</h1>

<button (click)="firstClick()">Click me</button>
```
Setup the home component as weel
```ts
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  firstClick() {
    console.log('clicked');
  }

}
```


change the **nav.component.html** to 
```html
<header>
  <div class="container">
    <a routerLink="/" class="logo">{{ appTitle }}</a>
    <nav>
      <ul>
        <li><a routerLink="/">Home</a></li>
        <li><a routerLink="/posts">Posts</a></li>
      </ul>
    </nav>
  </div>
</header>
```

change the **nav.component.ts** to 
```ts
export class NavComponent implements OnInit {

   appTitle = 'FMCat';

   constructor() { }

   ngOnInit() {
   }

 }

```
add some ccs to the global css in /src/styles.scss
```css
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,700');

body, html {
    height: 100%;
    margin: 0 auto;
}

body {
    font-family: 'Montserrat';
    font-size: 18px;
}

a {
    text-decoration: none;
}

.container {
    width: 80%;
    margin: 0 auto;
    padding: 1.3em;
    display: grid;
    grid-template-columns: 30% auto;

    a {
        color: white;
    }
}

section {
    width: 80%;
    margin: 0 auto;
    padding: 2em;
}
```


custom css for the **nav.component.scss**
```ts
header {
    background: #7700FF;

    .logo {
        font-weight: bold;
    }

    nav {
        justify-self: right;
    
        ul {
            list-style-type: none;
            margin: 0; padding: 0;

            li {
                float: left;

                a {
                    padding: 1.5em;
                    text-transform: uppercase;
                    font-size: .8em;

                    &:hover {
                        background: #8E2BFF;
                    }
                }
            }
        }
    }
}
```

Setup the routing (navigation) editing the **app-routing.module.ts**
```ts
// add imports

import { HomeComponent } from './home/home.component';
import { PostsComponent } from './posts/posts.component';

// add the routes

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'posts', component: PostsComponent },
];
```











Now lets see how to connect NodeJS/Angular to data services...


### 4 Conencting NodeJS to FileMaker Server (DATA API)

Use the NodeJS to FileMaker Data API wrapper created by Jacob Thomann from https://thomann061.github.io/fmrest/



```bash
npm install fmrest
```
From here you can integrate FileMaker Data into any NodeJS app:

NOTE: check if we have DAT API acces to our database creted in the WorkShop PART 1
(Open Postman and test it). Check FileMaker [DATA API](https://fmhelp.filemaker.com/docs/17/en/dataapi/index.html) here


Get the authorization token from the server (TTL is 15 minutes)
```bash
curl -X POST 
 https://remoto.codroper.com/fmi/data/v1/databases/FMCat/sessions 
 -H 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' 
 -H 'Content-Type: application/json' 
 -d '{}'
```
with postman, get session token

![](http://www.ntwk.es//images/fmcat-sessions-dataapi-auth.png)

get records

![](http://www.ntwk.es//images/fmcat-sessions-dataapi-getrecords.png)

Please use our FMCat Postman Collection to run the tests above. You must setup your environment parameters since the demo server will be available only during this workshop.

[![Run in Postman]
(https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a3207c331f3d2c79d864)


With the fmrest wrapper in NodeJS, sample authorization (get session token)

```javascript
const Fmrest = require('fmrest');

// SBasic configuration
const filemaker = new Fmrest({
    user: "admin",
    password: "wakawaka",
    host: "http://remoto.codroper.com",
    database: "FMCat"
});

filemaker.setLayout('post');

```
Basic login

```javascript
filemaker
    .login()
    .then(body => {
        console.log(JSON.stringify(body, null, 3));
    });
    
```
Or logout

```javascript
filemaker
    .logout()
    .then(body => {
        console.log(JSON.stringify(body, null, 3));
    });
```

Create a find request

```javascript
let request1 = filemaker
    .createRequest()
    .where('title').is('=*');
    
let request2 = filemaker
    .createRequest()
    .where('author_id').is('=9');
      
let sort = filemaker
    .createSort('title', 'ascend');
    
filemaker
    .find({
        requests: [request1, request2],
        sorts: [sort],
        offset: 0,
        limit: 10
    })
    .then(body => {
        console.log(JSON.stringify(body, null, 3));
    })

```


#### Connect our test app to our data services

go to our node/angular app and generate a data service:

```bash
ng generate service data
```
modify the **data.service.ts** adding
```ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  // Import it up here

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getPosts() {
    return this.http.get('http://localhost:8080/posts');
  }
}
```

modify the **posts.component.ts** adding
```ts
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  posts: Object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getPosts().subscribe(data => {
        this.posts = data;
        console.log(this.posts);
      }
    );
  }

}
```
add the service to **app.module.ts** adding
```ts
... 

import { HttpClientModule } from '@angular/common/http';

...

imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],

```


modify the **post.component.html** adding
```html
<h1>Posts</h1>

<ul *ngIf="posts">
  <li *ngFor="let post of posts.data">
    <p>{{ post.id }} {{ post.title }}</p>
  </li>
</ul>
```
and style it at **post.component.scss**
```scss
ul {
    list-style-type: none;
    margin: 0;padding: 0;

    li {
        background: rgb(238, 238, 238);
        padding: 2em;
        border-radius: 4px;
        margin-bottom: 7px;
        display: grid;
        grid-template-columns: 60px auto;

        p {
            font-weight: bold;
            margin-left: 20px;
        }

        img {
            border-radius: 50%;
            width: 100%;
        }
    }
}
```







### End

Not bad

Anyway we want something more powerfull and easy (is possible?), so we need to buil someting much bigger... Jump to part 3



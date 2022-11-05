# Getting Started with spring-boot, spring-mvc, gmail-api and react

This project is a setup sample for a simple api which store and read from a mysql db a list of contact from a 
Google account. You can also change the api url and scope which will provide access to others Google account data. 

## Modules
### Backend
* spring-boot
* spring-mvc
* maven
* Docker
* mysql

### Frontend
* React
* material-ui
* google gmail-api



## Installation and Getting Started

### Requisites
* Java 11 or greater
* Node 14 or greater
* NPM 8 or greater
* Docker 20.10.20 or greater


### Set your google api key and 
Replace your own api key and client id in index.html 
```
const CLIENT_ID = 'YOUR_CLIENT_ID';
const API_KEY = 'YOUR_API_KEY';
```

If you want to change the data to receive from google, you can change the discovery URL. I use Google people api:
```
// const DISCOVERY_DOC = 'https://www.googleapis.com/discovery/v1/apis/gmail/v1/rest';
const DISCOVERY_DOC = 'https://www.googleapis.com/discovery/v1/apis/people/v1/rest';
```

#### More information about generating a google api key:
Follow the instructions: 
https://developers.google.com/gmail/api/quickstart/js


### Start up the DB
Open a terminal and execute from the root directory
```
$ cd Docker
$ docker-compose  up
```

### Start up the Backend
Open a new terminal and run next command from the root directory
```
$ ./mvnw install
$ ./mvnw spring-boot:run
```

### Start up the FrontEnd
Open a new terminal and run next command from the root directory
```
$ npm install
$ npm start
```



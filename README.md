# urlshortnerkotlin App
https://github.com/AnkitaArya/urlshortnerkotlin
### Author - Ankita Arya

#### Description:
This application is responsible for converting long urls to shortened version for the ease of using and
vice versa , i.e. converting short urls back to long versions.
This application consists of various APIs to perform the long to short or short to long conversions.
 
#### Tech Stack:
Java - Kotlin, Spring Boot, Rest APIs, Microservice Architecture, H2Db(in memory), Maven, JPA, Swagger

#### Pre-Requisites:
Before executing the app , you may require :
Java/Kotlin
SpringBoot
Maven
any IDEs, etc.

#### Steps To Setup:
1. Import the files into an IDE.
2. Once done, right click the root folder of the project and select maven build. Or you can tyoe in the command prompt - mvn clean install. 
   This will download all the necessary libraries, the project requires.
3. Once downloaded, now you can again right click the project root folder and select Run As SpringBoot Application , under Run as option.
4. Once execute successfully, click on the link http://localhost:8080/swagger-ui.html to have the feel of the application.
5. Utilise various APIs listed, as per the needs.

#### Features:
Url Shortner application consists of couple of APIs for different operations :
1. User want to shorten a valid long url.
2. User want to get the original(long) version of his already shortened url.

#### Future Scope:
Due to the time constraint, this application only caters the most basic needs of shortening process.
But the scope of this application is much broader and needs to be expanded further by implementing below features as future plan :
1. Authentication & authorization needs to be added to secure the access of this app. (OAuth2.0 - JWT)
2. Infrastructure needs to be added with load balancer
3. Deployment pipelines needs to be integrated with the application.
4. Basic validations had been added which can be upgraded for further robustness.
5. Testing suit needs to be integrated.

#### Response :
Response would consist below properties - 
1. FullUrl 
2. ShortUrl 

#### Validations:
1. Currently only validation is to check if no malicious elements are added in the request
   object. Basic url characters are only allowed.

#### License:
This is an open source project and you are free to copy, modify, and distribute the project.

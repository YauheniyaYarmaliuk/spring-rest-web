# SPRING-REST-WEB
----
## what's spring-rest-web?
It's spring project, where head is parent for three modules:module, rest, web

----
## module
It's POJO for rest and web

----
## rest
RESTful web service, which output requests in  json formats
Http methods: GET, PUT, POST, DELETE.

All URL is used prefix **localhost:8080/rest**
* /employees
* /departments
* /avgSalary
* see more in the package com.zhenya.rest.controller

----
## web
RESTFul client to consume APIs. 
Accessing a third-party REST service inside a Spring application revolves around the use of the Spring RestTemplate. 
Given that the RestTemplate  is designed to call REST services, 
which are the HTTP protocol’s methods: GET, POST, PUT, DELETE.
Example it’s methods are  getForObject(), postForObject(), put() and delete() .

All URL is used prefix **localhost:8080/web**
* /employee
* /department
* /avgSalary

----
## Building with Maven

*$ mvn clean package*

----
## thanks!


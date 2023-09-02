## Benefits of Using a RESTful API
The benefits of using RESTful API, is that it allows for a standardrized way to communicate over HTTP request, like GET, POST, PUT and DELETE. It can also be used for all kind of different platforms, and languages, which it makes it really flexible. In this program by using the different HTTP request, it makes its much easier to seperate what the different endpoints do, and with what methods in our service class. 

## What is JSON and its Compatibility with REST?
JSON stands for Javascript Object Notation, and its is an easy way for people to read/write data, and thats is mainly on how its been sat up with the different attributes the programmer is providing the application, and then is displays in a very nice way. 

Its compatibility with REST, is that JSON is a very lightweight language, and that makes it ideal to work with web-applications, and with REST ways of handling HTTP requests, it makes it makes very easy to display data in the browser.

## Designing CRUD Endpoints with Spring Boot and DTOs
Designing the CRUD Endpoints works with the HTTP requests like GET, POST, PUT and DELETE, that are anontations we give in our Controller class, and is where we build our endpoints, with our methods, and then I have exstracted my methods from my service class over to the controller class. 

The methods we make in our controller class depends on our methods in our service class, where I build the logic on how to make the different CRUD's. It also there I make use of the different DTO classes **MemberRequest** and **MemberResponse**. DTO stands for Data Transfer Obejcts, and is where we can take data we need in certains situations and use them. In this case **MemberRequest** is where we have all of the data that we always have to use like **username**, **email** or **city**, and then **MemberResponse** is where we have some more of the same data, but some more addOn data like **created** and **lastEdited**. In our service class, I usually use the **MemberResponse** class, to set our methods, because some of the methods are use for adding, editing and deleting the members, and the we will have to use the data from **MemberResponse** class to see more data then from the **MemberRequest** class. 
  
## Advantages of Using DTOs in REST Endpoint Design
The advantages of using DTOs in REST Endpoint Design, is that its more flexible when we work with a lot of data, and ensures its only the data that is relevant to what we want our endpoints to do. 

## Concept of Mocking in Software Testing
The concept of Mocking in Software Testing is that we use a dummy version of some specific data, that we can use in our Unit tests, and is a very simple way of testing our different methods. In this application I have put some specific data ínto the test class, in this case data about **Members**, with that we are able to make test with all of the data about members in any way we want. 

## Mocking Database Access in Tests with In-memory Databases and Mockito
In-memory Databases and Mockito both have the same pourpose with testing in Java, but have different ways of doing so. 

In this application I have used **H2 In-memory Databases** to test the different methods, and these databases are able to mimic the behavoirs of real databases, which what makes so good at testing.

**Mockito** is a framework in Java that also helps with testing, but I have chossen not to use it here. Mostly because **H2 In-memory Databases** seems more traditional, and I have worked with that sort of testing more. Of course Mockito seems more straightforward, and seems to create a bigger overview of the tests, with how its more explict with what you want to mock. 

## Understanding Build Server and GitHub Actions' Role
Build Server is where we have taken our application, and build a App Service on (in this case Azure), and chosen our Github repository that takes to source code from that, and then automatically makes a **yml file**, and create these **Github actions** with the different jobs, to test to see if the application actually can be build with, and then afterwards deployed to the cloud.  

## Maven's Significance and its Integration with GitHub Actions in CI

## Cloud Service Models Used for the Project Handin


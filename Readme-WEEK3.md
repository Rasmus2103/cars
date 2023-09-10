## Where and Why You Have Used a `@OneToMany` Annotation
I have used @OneToMany Annontation in my **Member** entity class, and have set a list with reservations, and giving it the FetchType.LAZY. The reason I have givin it the **@OneToMany** annontation is because of the relationship between **Member** and **Reservations**. Since member can have multiple reservations, it makes since for it to have OneToMany annontation. I have chosen to only give them a FetchType.LAZY, because the LAZY type only fethces the informations when giving access to them.  

## Where and Why You Have Used a `@ManyToOne` Annotation
I have used @ManyToOne annontation in my **Reservation** entity class and initianzed with my **Member** and **Car** class, because, because in how the application is set up, both car and member can have many reservations, but there can only a reservation for each pacticular member and car. 

## The Purpose of the CascadeType, FetchType, and mappedBy Attributes You Can Use with One-to-Many


## How/Where You Have (If Done) Added User Defined Queries to Your Repositories

## A Few Words Explaining What You Had to Do on Your Azure App Service to Make Your Spring Boot App Connect to Your Azure MySqlDatabase

## A Few Words About Where You Have Used Inheritance in Your Project, and How It's Reflected in Your Database

## What Are the Pros & Cons of Using the Single Table Strategy for Inheritance?

## How Are Passwords Stored in the Database with the Changes Suggested in Part-6 of the Exercise



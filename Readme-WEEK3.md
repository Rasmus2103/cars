## Where and Why You Have Used a `@OneToMany` Annotation
I have used @OneToMany Annontation in my **Member** entity class, and have set a list with reservations, and giving it the FetchType.LAZY. The reason I have givin it the **@OneToMany** annontation is because of the relationship between **Member** and **Reservations**. Since member can have multiple reservations, it makes since for it to have OneToMany annontation. I have chosen to only give them a FetchType.LAZY, because the LAZY type only fethces the informations when giving access to them.  

## Where and Why You Have Used a `@ManyToOne` Annotation
I have used @ManyToOne annontation in my **Reservation** entity class and initianzed with my **Member** and **Car** class, because, because in how the application is set up, both car and member can have many reservations, but there can only a reservation for each pacticular member and car. 

## The Purpose of the CascadeType, FetchType, and mappedBy Attributes You Can Use with One-to-Many
CascadeType is what happends with different entitys/columms are updated, persisted or deleted. In this application we have relationships with two different columns, and we have to have some way to be handled if there in some way any there are being altered. 

The FetchType have two options **EAGER** and **LAZY**. **EAGER** means that the associated entities will be loaded immediately when we fetch the owning entity. **LAZY** means that the associated entities will be loaded from the database only when we want access them explicitly. We have in this use more of the **LAZY** option because we in our methods specifically ask the get something from the column. 

The mappedBy attribute is used in a bidirectional relationship between entities, and ensures that changes made on one side of the relationship are correctly synchronized with the other side. 

## How/Where You Have (If Done) Added User Defined Queries to Your Repositories

## A Few Words Explaining What You Had to Do on Your Azure App Service to Make Your Spring Boot App Connect to Your Azure MySqlDatabase

## A Few Words About Where You Have Used Inheritance in Your Project, and How It's Reflected in Your Database

## What Are the Pros & Cons of Using the Single Table Strategy for Inheritance?
**Pros** 


## How Are Passwords Stored in the Database with the Changes Suggested in Part-6 of the Exercise



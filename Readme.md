# ORM-Mapper: Begreber og Implementering i Java

## Ideen og grunde til at bruge en ORM-Mapper

Mine grunde til at bruge ORM-Mapper er at selvom det kræver ret meget forståelse for de forskellige ting der er i det, så er det fantastisk at bruge på baggrund af at det kræver meget lidt kode for at få det til at køre. Man sparer samtidig en masse tid når man både skal sætte en masse data, og samtidig have en applikation til at køre, og det er fantastisk at vide at man kan sætte en tabeller op i en database uden brug at SQL-queries, hvilket kan give mange irriterende komplikationer. 

## Forståelse af JPA, Hibernate og Spring Data JPA

- **Resumé**: Udtrykkene JPA (Java Persistence API), Hibernate og Spring Data JPA optræder ofte sammen, når man diskuterer datapersistens i Java. At forstå deres sammenhæng kan i høj grad forenkle processen med at udvikle og vedligeholde Java-applikationer. Dit korte resumé her

## Oprettelse af Java Entiteter og Mapping Dem til en Database Ved Brug af Spring Data API

Såden som jeg gjorde det var at 

## Kontrol af Mapping Mellem Entitetsklasse Felter og Database Kolonner

Den måde jeg sørgede for Kontrol mellem Entitetsklasse felterne og Database Kolonner, var 

## Auto-Generering af IDs med Database Specifikke Præferencer (Auto Increment for MySQL)

- **Implementering**: Hvordan du gjorde det i din kode

## Brug og Definition af Repositories med Spring Data JPA's Repository Mønster

- **Implementering**: Hvordan du gjorde det i din kode

## Skrivning af Simple "Integration" Tests Ved Brug af H2 som en Mock-Database

Det jeg gjorde da jeg lavede tests var at starte med lave en annontation med **@DatabaseJpaTest**, hvilket er nødvendigt fordi den laver en såkaldt **in-memory database** der kan teste mod den rigtige database vi har oprettet. Efterfølgende gjorde man det som man kender for unit tests hvor man satte det op med **@BeforeEach** annontation, og så gik man så ind, og kaldte på den abstakte metode **deleteAll()** fra både Car og Member Entinty klassen. Samtidig også satte en boolean variabel **IsInitialized**, for at sørge for bedre effiktivitet, og for at sikre en at det kun bliver udført 1 gang ved at sætte boolean variablen til false til at starte med, og så sætte den true når man kører testene. 

## Tilføjelse af (Udviklings) Forbindelsesdetaljer for Lokal MySQL Database

- **Implementering**: Hvordan du gjorde det i din kode


## Adding (Dev) Connection Details for Local MySQL Database

- **Implementation**: How you did that in your code


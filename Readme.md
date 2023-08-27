# ORM-Mapper: Begreber og Implementering i Java

## Ideen og grunde til at bruge en ORM-Mapper

Mine grunde til at bruge ORM-Mapper er at selvom det kræver ret meget forståelse for de forskellige ting der er i det, så er det fantastisk at bruge på baggrund af at det kræver meget lidt kode for at få det til at køre. Man sparer samtidig en masse tid når man både skal sætte en masse data, og samtidig have en applikation til at køre, og det er fantastisk at vide at man kan sætte en tabeller op i en database uden brug at SQL-queries, hvilket kan give mange komplikationer. 

## Forståelse af JPA, Hibernate og Spring Data JPA

Den er jeg ikke sikker på. 

## Oprettelse af Java Entiteter og Mapping Dem til en Database Ved Brug af Spring Data API

Jeg oprettede en mappe kaldet **entity**, hvor jeg tilføjer alle mine entity klasser. Disse entititeter repræsenterer database tabeller, og så ved hjælp har jeg teknisk set oprettede en database inde i min java klasse, og så er jeg i stand til extended den til mit repository interface klasse, og så er de i stand til at lave de forskellige CRUD metoder derfra. 

## Kontrol af Mapping Mellem Entitetsklasse Felter og Database Kolonner

Den måde jeg sørgede for Kontrol mellem Entitetsklasse felterne og Database Kolonner, var atsørge at alle de attributter der var i mine Entity klasser havde en annontation **@Column**, og gav dem alle sammen et **name**, der sørgede for at lave database kolonner ud fra det navn man har givet dem.  

## Auto-Generering af IDs med Database Specifikke Præferencer (Auto Increment for MySQL)

Det eneste jeg ikke gav en kolonne, var min første attribut, der typisk er min primary key der så bliver givet et **@Id** annontation til, og den behøver ikke at blive givet en **@Column** annontation til, da den bliver lavet til min primary key. Hvis man arbejder med et decideret Id, og man definerer den som en Integer, vil man typisk give den der her annonatation **@GeneratedValue(strategy = GenerationType.IDENTITY)**, der gør at ens Id bliver auto_incrementet. 

## Brug og Definition af Repositories med Spring Data JPA's Repository Mønster

Såden som jeg gjorde det i min kode, var at extended den til JPA til et interface med et af de givne entitere, og ved hjælp af det bliver det muligt for den, at lave de velkendte CRUD metoder der opretter, sletter og opdatere alt den data vi indsætter ind i vores database i vores applikation. Efterfølgende kan jeg så ved hjælp af de forskellige repositories være i stand til at implementere dem i andre klasser hvor jeg skal bruge de forskellige CRUD metoder. F.eks. bruger jeg den i min **Delevolper** klasse, hvor jeg indsætter data, og gør det muligt for mig at gemme dem. 

## Skrivning af Simple "Integration" Tests Ved Brug af H2 som en Mock-Database

Det jeg gjorde da jeg lavede tests var at starte med lave en annontation med **@DatabaseJpaTest**, hvilket er nødvendigt fordi den laver en såkaldt **in-memory database** der kan teste mod den rigtige database vi har oprettet. Efterfølgende gjorde man det som man kender for unit tests hvor man satte det op med **@BeforeEach** annontation, og så gik man så ind, og kaldte på den abstakte metode **deleteAll()** fra både Car og Member Entinty klassen. Samtidig også satte en boolean variabel **IsInitialized**, for at sørge for bedre effiktivitet, og for at sikre en at det kun bliver udført 1 gang ved at sætte boolean variablen til false til at starte med, og så sætte den true når man kører testene. 

## Tilføjelse af (Udviklings) Forbindelsesdetaljer for Lokal MySQL Database

Jeg tilføjer alle de forbindelsesdetajler som **database username**, **database password**, og **database url** som miljøvariabler i min configuration indstilling i min applikation, og ved hjælp af det gør det muligt for at den lave en virtuel database, der kan connecte til den. Jeg sørger stadig for at tilføje den til min **application.properties** fil. 


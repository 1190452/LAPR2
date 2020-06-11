# UC5 - Regist Historical Transaction

## 1. Requirements Engineering

### Brief Format

The collaborator beggins loading the file with historical transactions. The system request for the necessary data about the file(i.e. file name). The collaborator introduces the data requiered. The system request confirmation. The collaborator confirms. The system load the file and records the transactions data and informs the collaborator about the success of the operation.

### SSD
![UC5_SSD.svg](UC5_SSD.svg)


### Complet Format

#### Main actor

Collaborator

#### Stakeholders and their interests
* Collaborator: pretends to load the historical transactions to see them.
* Organization: to has access of all transactions done.

#### Preconditions
* file must be created

#### Postconditions
* Organization has already all the transactions that have been done.

#### Main success scenario (or basic flow)

1. The collaborator starts loading the file.
2. The system request for the necessary data (i.e. file name). 
3. The collaborator introduces the data requiered.
4. The system request confirmation.
5. The collaborator confirms.
6. The system save the transactions history and notify the collaborator about the sucess of the operation.

#### Extensions (or alternative flows)

*a. The collaborator requests to cancel the creation.

> The use case ends.
	
4b. Missing minimum required data.
>	1. The system advice which data is missing.
>	2. The system allows the entry of missing data (step 2)
>
	>	2a. The collaborator doesn´t change the data. The use case ends.

4c. The system idenfitifies that the file name entered doesn´t correspond to a created file.
>	1. The system alerts collaborator about the fact.
>	2.The system allows its change (passo 2)
>
	>	2a. The collaborator doesn´t change the data. The use case ends.


#### Special requirements
n/a

#### List of Technologies and Data Variations
n/a

#### Frequency of Occurrence
n/a

#### Open questions

* How many files the collaborator can load?

## 2. OO Analysis

### Excerpt From The Relevant Domain Model For UC

![UC5_MD.svg](UC5_MD.svg)


## 3. Design - Use case realization

### Rational

| Main flow | Question: what class... | Answer | reason |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The collaborator starts uploading the file.|... interacts with the user?| HistoricalTransactionUI |Pure Fabrication|
|             |... coordinates the UC?| HistoricalTransactionController |Controller|
|             |... create instances of file?|Collaborator|Creator(rule1)|
|2. The system request the necessary data about the file (i.e. file name).||||
|3. The collaborator introducethe required data. |... saves the entered data?|Organization|IE: instance created in step 1|
|4. The system validates and show the data, asking confirmation. |... validate the data of Reader? (local validation)|ImportFile|IE: instace created in step1|
|             |...validate the data of ImportFile? (global validation)|Organization|IE: Organization has historical transactions.|
|5. The collaborator confirms. ||||
|6. The system load all the information and notify the collaborator about the sucess of the operation.|... saves the ImportFile created?| Organization |IE: No MD the Organization has historical transactions|
             

### Sistematization ##

 From rational results that conceptual classes  conceptuais promoted to software classes are:

 * Organization 
 * Collaborator
 * ImportFile


Other software classes (i.e. Pure Fabrication) identified:  

 * HistoricalTransactionUI  
 * HistoricalTransactionController


###	Sequence Diagram

![UC5_SD.svg](UC5_SD.svg)



###	Class Diagram

![UC5_CD.svg](UC5_CD.png)


# UC8 - Check Overall Statistics

## 1. Requirements Engineering

### Brief Format

The collaborator/manager beggins watch overall statistics about task execution times and freelancer payments. The system show the statistics about task execution times and freelancer payments the and informs the manager/collaborator about the success of the operation.

### SSD
![UC8_SSD.svg](UC8_SSD.svg)


### Complet Format

#### Main actor

Manager/Collaborator

#### Stakeholders and their interests
* Collaborator: pretends to se overall statistics.
* Manager: pretends to se overall statistics.
* Freelancer: pretends to see your own statistics.

#### Preconditions

#### Postconditions

#### Main success scenario (or basic flow)

1. The collaborator/manager beggins watch overall statistics about task execution times and freelancer payments.
2. The system show the statistics about task execution times and freelancer payments the and informs the manager/collaborator about the success of the operation.


#### Extensions (or alternative flows)

*a. The collaborator requests to cancel the creation.

> The use case ends.
	
#### Special requirements
n/a

#### List of Technologies and Data Variations
n/a

#### Frequency of Occurrence
n/a

#### Open questions

## 2. OO Analysis

### Excerpt From The Relevant Domain Model For UC

![UC8_MD.svg](UC8_MD.svg)


## 3. Design - Use case realization

### Rational

| Main flow | Question: what class... | Answer | reason |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The collaborator/manager starts watching overall statistics|... interacts with the user?| WatchStatisticsUI |Pure Fabrication|
| |... coordinates the UC?|  WatchStatisticsController |Controller|
|2. The collaborator/manager beggins watch overall statistics about task execution times and freelancer payments. The system show the statistics about task execution times and freelancer payments the and informs the manager/collaborator about the success of the operation. | ...knows the payment of each freelancer? | RegisterTransactions | HC+LC |
| | ...knows RegisterTransactions | Platform| IE: MD show that Platform has RegisterTransactions |
| | ...knows task execution times of each freelancer? | TaskExecution | IE: TaskExecution knows its own data |




             

### Sistematization ##

 From rational results that conceptual classes  conceptuais promoted to software classes are:

 * Platform
 * Collaborator
 * Reader


Other software classes (i.e. Pure Fabrication) identified:  

 * ReaderUI  
 * ReaderController


###	Sequence Diagram

![UC5_SD.svg](UC5_SD.png)



###	Class Diagram

![UC5_CD.svg](UC5_CD.png)


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
|2. The collaborator/manager beggins watch overall statistics about task execution times and freelancer payments. The system show the statistics about task execution times and freelancer payments the and informs the manager/collaborator about the success of the operation.||...knows the list of Freelancers? | RegisterFreelancer | HC+LC |
| |...knows the payment list of each freelancer? | Freelancer | IE: has its own data |
| |...knows the transactions of each payment? | Payment | IE: has its own data |
| |...knows the delay of each freelancer? | TaskExecution | IE: TaskExecution knows its own data | 
| | ...knows TaskExecution? | Transaction | IE: Transaction created TaskExecution, therefore Transaction knows the data about TaskExecution |
| | ...calculates the payment for each task of each freelancer? | Transaction | IE: Transaction has the cost per hour and the time that the task took.|
| |...knows RegisterFreelancer? | Platform | IE: Platform has RegisterFreelancer | 
             

### Sistematization ##

 From rational results that conceptual classes  conceptuais promoted to software classes are:

 * Platform
 * TaskExecution


Other software classes (i.e. Pure Fabrication) identified:  

 * WatchStatisticsUI  
 * WatchStatisticsController
 * RegisterTransactions


###	Sequence Diagram

![UC8_SD.svg](UC8_SD.svg)

![UC8_SD_getFreelancer.svg](UC8_SD_getFreelancer.svg)





###	Class Diagram

![UC8_CD.svg](UC8_CD.png)


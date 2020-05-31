# UC 9 - Check Freelancer Performance

## 1.Requirement Engineering

### Brief format
The Administrator starts the visualization of the performance of the freelancers. The system shows the statistics describing the performance of the freelancers (the mean and the standard deviation of the delays and payments of all the freelancers and the histrograms that represent that) and shows the probability that the sample mean is higher than 3 hours.


### SSD
![UC_SSD.svg](UC9_SSD.svg)


### Full Format

#### Main Actor

Administrator

#### Stakeholders and their interests
**Administrator**: intends to see the performance of the freelancers
**Freelancer**: intends to know if they performing accordingly to the necessary

#### Preconditions

n/a

#### Postconditions
* The system should show the Administrator the performance of all the freelancers(with and without histograms).

#### Main success scenario 

1. The Administrator starts the visualization of the performance of the freelancers.
2. The system shows the statistics describing the performance of the freelancers (the mean and the standard deviation of the delays and payments of all the freelancers and the histrograms that represent that) and shows the probability that the sample mean is higher than 3 hours.

#### Extensions

*a. The Administrator ends the visualization of freelancer performances
> The use case ends.


#### Special requirements
\-

#### Lista of Data and Techonology variation
\-

#### Frequency of Occurence

\-

#### Open Questions

\-

## 2. Object oriented analysis

### Excerpt from the Relevant Domain Model for UC

![UC9_MD.svg](UC9_MD.svg)


## 3. Design - Realização do Caso de Uso

### Racional

| Main Flux | Question: Which class... | Answer  | Justification  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The Administrator starts the visualization of the performance of the freelancers. |...interacts with the user? | CheckPerformanceUI | Pure Fabrication|
|             |...coordinates the UC? | CheckPerformanceController | Controller |
|2. The system shows the statistics describing the performance of the freelancers (the mean and the standard deviation of the delays and payments of all the freelancers and the histrograms that represent that) and shows the probability that the sample mean is higher than 3 hours. | |...knows the list of Freelancers? | RegisterFreelancer | HC+LC |
| |...knows the payment list of each freelancer? | Freelancer | IE: has its own data |
| |...knows the transactions of each payment? | Payment | IE: has its own data |
| |...knows the delay of each freelancer? | TaskExecution | IE: TaskExecution knows its own data | 
| | ...knows TaskExecution? | Transaction | IE: Transaction created TaskExecution, therefore Transaction knows the data about TaskExecution |
| | ...calculates the payment for each task of each freelancer? | Transaction | IE: Transaction has the cost per hour and the time that the task took.|
| |...saves the probability that the sample mean is higher than 3 hours? | RegisterFreelancer | HC+lC |
| |...knows RegisterFreelancer? | Platform | IE: Platform has RegisterFreelancer | 



### Sistematization ##

From the racional, the conceptual classes that are promoted to software classes are:

 * Platform
 * Transaction
 * Payment
 * Freelancer
 * TaskExecution
 


Other software classes (eg: Pure Fabrication) identified:

 * CheckPerformanceUI
 * CheckPerformanceController
 * RegisterFreelancer
 

### Sequence Diagram

![UC9_SD.svg](UC9_SD.svg)



### Class Diagram

![UC9_CD.svg](UC_CD.svg)


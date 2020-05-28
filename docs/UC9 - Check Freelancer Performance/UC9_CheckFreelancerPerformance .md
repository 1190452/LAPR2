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
|1. The Collaborator beggins the creation of a payment transaction. |... interacts with te Collaborator?| CreateTransactionUI |Pure Fabrication|
| |... coordinates the UC?| CreateTransactionController |Controller|
| |... creates instances of Transaction |RegisterTransaction|Creator(rule1) combined with HC+LC with Platform.|
| |...knows RegisterTransaction? | Platform | IE: Platform has RegisterTransaction |
|2. The system shows the Collaborator a list of tasks and asks him to choose one.|...has the list of tasks?| TaskList|HC+LC with Platform|
|  |...knows TaskList? | Organization | IE: Organization has TaskList | 
|3. The collaborator chooses one task from the list. ||||
|4. The system shows the collaborator a list of freelancers that are present in the system and asks the collaborator once again to choose of of them.|...has the list of Freelancers?| RegisterFreelancer| HC+LC|
| |...knows RegisterFreelancer?| Platform | IE: Platform has RegisterFreelancer |
|5. The collaborator chooses one freelancer from the list. |... 
|6. The System asks for the rest of the necessary data(details about the execution of the task(end date, delay, brief description of the quality of the work)).|||| 
|7. The Collaborator introduces all the necessary data.|...saves all the information introduced? | Transaction | Creator (rule1) |
|8. The system shows the data to the Collaborator and asks him to confirm |... validates the Transaction data (Global validation)? | RegisterTransaction | HC+LC combined with IE, because RegisterTransaction has all the Transactions|
|    |...validates the Transaction data (local validation)? | Transaction | IE: knows its own data |
|9. The collaborator confirms.|||| 
|10. The system registers the data and informs the Collaborator that the operation was successful. |...saves the created instance of Transaction | RegisterTransaction| HC+LC | 


### Sistematization ##

From the racional, the conceptual classes that are promoted to software classes are:

 * Platform
 * Organization
 * Transaction
 


Other software classes (eg: Pure Fabrication) identified:

 * CreateTransactionUI
 * CreateTransactionController
 * RegisterTransaction
 * RegisterFreelancer
 * TaskList
 
 


### Sequence Diagram

![UC4_SD.svg](UC4_SD.svg)



### Class Diagram

![UC4_CD.svg](UC4_CD.svg)


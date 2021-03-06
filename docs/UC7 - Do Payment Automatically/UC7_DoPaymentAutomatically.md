# UC 7 - Do Payment (Automatically)

## 1. Requirements Engineering

### Brief Format

The timer starts the automatic payment process time using the define payment, triggering the process at the defined date and time.

### SSD

![UC7_SSD](UC7_SSD.svg)

### Full Format

#### Main Actor

Timer

#### Stakeholders and their interests

* **Organization:** intends to pay the freelancers.
* **Manager:** intends to define the hour of the transactions from the organization that are not paid.
* **Freelancer:** intends to receive the payment for the work made.

#### Preconditions


#### Post-conditions

The Freelancer receives the payment

#### Main success scenario (or basic flow)

1. The timer starts the automatic payment process.
2. The system makes payments using the payment list, triggering the process at the defined date and time, generating the receipt , registering the total value that the organization spent, and sending an email to every freelancer.

#### Extensions (or alternative flow)


*2a. There is no date and time defined in the DefinePayment.
> The use case ends.

2b. There is Task to be payed.
> The use case ends.

#### Special Requirements

#### List of Technologies and Data Variations

#### Frequency of Occurrence

When the manager defines the hour of the payments.

#### Open questions


## 2. OO Analysis

### Excerpt from the Relevant Domain Model for UC

![UC7_MD](UC7_MD.svg)

## 3. Design - Use Case Realization

### Rational

| Main Flow | Question: Which Class ... | Answer  | Justification  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. The timer starts the automatic payment process at the stipulated time.      | ...creates the instance of the Task?  | Platform | creator |
|       | ...coordinates the UC? | DoPaymentTask | Controller |
|       | ...knows the RegisterOrganizations? | Platform | IE and HC+LC |
|       | ...has every Organization? | RegistOrganizations | HC+LC |
|       | ...knows the DefinePayment? | Organization | IE: each organization has a DefinePayment |
|       | ...creates the instance of the Timer? | Platform | creator | 
|       | ...determines that time has been reached? | Timer | IE |
| 2. The system makes payments using the payment list, triggering the process at the defined date and time, generating the receipt and sending an email to every freelancer. | ...knows teh Platform? | ApplicationPOT | IE |
|       | ...knows the RegisterFreelancer? | Platform | IE and HC+LC |
|       | ...knows every Freelancer? | RegisterFreelancer | IE |
|       | ...knows the TaskList? | Organization | IE: Organization has tasks | 
|       | ...creates a temporary list to save the tasks for each freelancer? | DoPaymentTask | creator |
|       | ...has tasks? | TaskList | IE: task lists have tasks | 
|       | ...knows the RegisterTransaction | Organization | IE and HC+LC |
|       | ...knows every Transaction of each organization? | RegisterTransaction | IE and HC+LC |
|       | ...creates a temporary list to save the transactions for each freelancer? | DoPaymentTask | creator |
|       | ...knows the Writer? | DoPayementTask | IE |   


### Systematization ##

 From the rational the classes that are upgraded into software classes are:

 * Platform
 * Task
 * TransactionExecution
 * Writer
 * Organization
 * DefinePayment
 * Payment

 Other software classes (i.e. Pure Fabrication) identified:

 * DoPaymentTask 
 * TaskList
 * RegisterFreelancer
 * RegisterOrganizations
 * RegisterTransaction
 
 Other classes of external systems / components:
 
 * CurrencyConverter
 

###	Sequence Diagram

![UC7_SD.svg](UC7_SD.svg)

![UC7_SD_DoPayment.svg](UC7_SD_DoPayment.svg)


###	Class Diagram

![UC7_CD.svg](UC7_CD.svg)

* DoPaymentCD:

![UC7_CD_REF1.svg](UC7_CD_REF1.svg)




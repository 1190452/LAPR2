# UC 7 - Do Payment (Automatically)

## 1. Requirements Engineering

### Brief Format

The timer starts the automatic payment process at the stipulated time using the payment list, triggering the process at the defined date and time.

### SSD
![UC7_SSD](UC7_SSD.svg)


### Full Format

#### Main Actor

Timer

#### Stakeholders and their interests

* **Organization:** intends to pay the freelancers.
* **Freelancer:** intends to receive the payment for the work made.

#### Preconditions

The date and the time must be present in the system so that the timer can start the process at that moment.

#### Post-conditions

The Freelancer receives the payment

#### Main success scenario (or basic flow)

1. The timer starts the automatic payment process at the stipulated time.
2. The system makes payments using the payment list, triggering the process at the defined date and time.

#### Extensions (or alternative flow)


*2a. There is no date and time defined in the Payment.
> The use case ends.

2b. There is no payment in the Payment List to be made.
> The use case ends.

#### Special Requirements

#### List of Technologies and Data Variations

#### Frequency of Occurrence

Whenever time identifies that there is a payment to be made.

#### Open questions

How often is this process triggered?

## 2. OO Analysis

### Excerpt from the Relevant Domain Model for UC

![UC7_MD](UC7_MD.svg)

## 3. Design - Use Case Realization


### Rational

| Main Flow | Question: Which Class ... | Answer  | Justification  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. The Collaborator initiates the creation of the task. 		 | ...interacts with the user?						 |   CreateTaskUI          |       Pure Fabrication:it is not justified to assign this responsibility to any existing class in the Domain Model           |
|       | ...coordinates the UC? | CreateTaskController | Controller |
|       | ...creates Task instance? | TaskList | Creator (Rule1) + HC/LC:in the MD the Organization has a Task. By HC / LC delegates these responsibilities in Task List |
|       | ...knows the user / manager using the system? | Login  | IE:documentation of the user management component. |
|       | ...which organization the user / collaborator belongs to? | OrganizationRegister | IE: Knows every Organization |
|       |       | Organization | IE: Knows its Collaborator |
|       |       | Collaborator | IE: Knows his own data (e.g. email) |
| 2. The System asks for the data (id, brief description, time duration(in hours), cost per hour(in euros), task category). | 							 |             |                              |
| 3. The Collaborator writes the data down. | ...stores the data entered?  | Task     | instance created in step 1: it has its own data.                              |
| 4. The System validates, shows the data and asks for confirmation.		 |	...validates the Task data (local validation)?	 |    Task         |  IE:has its own data.                            |
|       | ...validates the Task data (global validation)?       | TaskList | IE:the TaskList contains Task |
| 5. The Collaborator confirms.	 | 							 |             |                              |
| 6. The System registers the data and informs about the success of the operation.  |	...keeps the created Task?		 |  TaskList    | IE:the TaskList contains Task  |

### Systematization ##

 From the rational the classes that are upgraded into software classes are:

 * Organization
 * Platform
 * Task

 Other software classes (i.e. Pure Fabrication) identified:

 * CreateTaskUI
 * CreateTaskController
 * TaskList
 * OrganizationRegister
 
 Other classes of external systems / components:
 
 * Login

###	Sequence Diagram

![UC2_SD.svg](UC2_SD.svg)

###	Class Diagram

![UC2_CD.svg](UC2_CD.svg)

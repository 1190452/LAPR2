# UC 3 - Create Freelancer

## 1. Requirements Engineering

### Brief Format

The collaborator starts creating a freelancer. The system requests the necessary (i.e. freelancer identifier, name, levelExpertise, email, nif, ibanAccount, country). The collaborator enter the requested data. The system presents the data and asks for confirmation. The collaborator confirms. The system informs the collaborator of the successfull of the operation.


### SSD
![UC3_SSD.png](UC3_SSD.png)


### Full format

#### Main actor
Collaborator

#### Stakeholders and their interests

**Collaborator:** intends to create freelancers to assign them to their tasks.

**T4J:** pretende que o freelancer em causa esteja registado no sistema de modo a utilizar a plataforma.

#### Preconditions

n/a

#### Postconditions

* The freelancer is created.


#### Main success scenario (or basic flow)

1. The collaborator starts creating a freelancer.
2. The system requests the necessary (i.e. freelancer identifier, name, levelExpertise, email, nif, ibanAccount, country).
3. The collaborator enter the requested data. 
4. The system validates, presents the data and asks for confirmation.
5. The collaborator confirms the data.
6. The system informs the collaborator of the successfull of the operation.


#### Extensions (or alternative flows)
 
1a. The collaborator requests to cancel the creation.
>    1. The use case ends.


4a. The collaborator does not enter all the requested data
>    1. The system informs you which data is missing.
>    2. The system allows the collaborator to enter the missing data (step 3).
>
	>	2a. The collaborator does not change the data. The use case ends.

11c. The system detects that the data (or some subset of the data) entered (i.e. freelancer identifier, ibanAccount) must be unique and that it already exists in the system.
>    1. The system alerts the collaborator to the fact.
>    2. The system allows the collaborator to change it (step 3)
>
	>	2a. The collaborator does not change the data. The use case ends.
     



#### Special requirements
--------------------

#### List of Technologies and Data Variations
--------------------

#### Frequency of Occurrence
--------------------

#### Open questions

* Are there any other mandatory data in addition to those already known?
* What data together can detect the duplication of freelancers?
* How often does this use case occur?
 
## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![UC3_MD.png](UC3_MD.png)


## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The collaborator starts creating a freelancer |... interact with collaborator?| CreateFreelancerUI |Pure Fabrication|
| |... coordinate the UC?| CreateFreelancerController |Controller|
| |... create instances of freelancer?|RegisterFreelancer|Creator(regra1) combinado com HC+LC sobre Plataforma.|
| |... knows RegisterFreelancer?| Platform | IE:
|2. The system requests the necessary (i.e. freelancer identifier, name, level Expertise, email, nif, iban account, country).|... interact with collaborator?| CreateFreelancerUI |Pure Fabrication|
|3. The collaborator enter the requested data|... save the entered data?|Freelancer|IE:|
|4. The system validates, presents the data and asks for confirmation |... validates freelancer data( Global Validation )|RegisterFreelancer| IE: |
| |... validates freelancer data( local Validation )|Freelancer| IE: |
|5. The collaborator confirms the data |||  |
|6. The system informs the collaborator of the successfull of the operation||| |


### Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * RegisterFreelancer
 * Freelancer
 * Platform

Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * CreateFreelancerUI  
 * CreateFreelancerController



###	Diagrama de Sequência

![UC3_SD.png](UC3_SD.png)




###	Diagrama de Classes

![UC3_SD.png](UC3_CD.png)



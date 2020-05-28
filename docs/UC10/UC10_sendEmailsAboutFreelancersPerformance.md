# UC 10 - Send emails about Freelancers performance

## 1. Requirements Engineering

### Brief Format

The timer starts the process of sending emails on the last day of the year according to the task delay and the percentage of the freelancers tasks delay.


### SSD

![UC10_SSD](UC10_SSD.png)


### Full format

#### Main actor

Timer

#### Stakeholders and their interests

* **Freelancer:** want to receive an email with your performance.

* **T4J:** intends for the platform to send performance reports to freelancers.


#### Preconditions

Exist freelancers to send emails.

#### Postconditions

The emails with the performance of the freelancers are sent to the respective

#### Main success scenario (or basic flow)

1. The last day of the year is reached .
2. The system checks if the process is taking place on the last day of the year, identify the freelancers who have a task delay greater than 3 hours and their percentage of task delay higher than the percentage of overall delays. Then sends emails to them.
 


#### Extensions (or alternative flows)

2a. The process is not taking place on the last day of the year.
> the use case ends.
 
2a. The system does not contain freelancers with a task delay greater than 3 hours or greater than the percentage of overall delays.
> the use case ends
 
 


#### Special requirements

####  List of Technologies and Data Variations

#### Frequency of Occurrence

All the last days of the years.

#### Open questions


## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![UC13-MD](UC13_MD.svg)

## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. O horário de seriação automática é atingido.|...coordena a uc?     |   SeriarCandidaturasAnuncioTask      |      Task    |
|       | ...determina que o tempo foi atingido? |     Timer       |   Timer        |
|       | ...cria a instancia do timer? |   Plataforma  | creator:Plataforma conhece as horas que a seriação deve começar                
|2. O sistema identifica o anúncio cujo tipo de regimento estipula que os critérios de seriação sejam objetivos, que estejam no período de seriação e que ainda não tenham sido seriados. Posteriormente, inicia o processo de seriação automática. |  ...possui o registo de anúncios de tarefas publicadas?		|  Plataforma | IE:no MD a plataforma possui anuncios.  |
|       | ...possui o anuncio  | RegistoAnuncios | IE: RegistoAnuncios contém/agrega Anuncio (segundo Padrão HC + LC) |
|       | ...possui a lista de Candidaturas? | Anuncio | IE: no MD o anuncio tem candidaturas |
|       | ...possui a candidatura? | ListaCandidaturas | IE: Lista de Candidaturas contem candidaturas |
|       | ...cria a instancia do processo de seriação? | Anuncio | creator: no MD o anuncio espoleta o processo de seriação |
|       | ...cria, valida e adiciona a instancia da classificação? | ProcessoSeriacao | creator: no MD a classificacao é resultante do processo de seriação |
|       | ...cria a instancia do processo de Adjudicacao?    |  RegistoAnuncios | creator: no MD o processo de adjudicacao está associado ao anuncio |
|       | ...possui o Freelancer? | Candidatura | IE: no MD a candidatura é efetuada pelo Freelancer |
|       | ...possui o Registo de Organizacao? | Plataforma | IE:a plataforma possui organizacao. |
|       | ...possui Organizacao? | RegistoOrganizacao | IE: RegistoOrganizacao contém/agrega Organizacao (segundo Padrão HC + LC)
|       | ...possui a tarefa? | Anuncio | IE: anuncio tem tarefa |
|       | ...cria e valida a instancia da Adjudicacao | Anuncio | creator: Anuncio tem adjudicacao |


### Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Plataforma
 * Anuncio
 * ProcessoSeriacao
 * Candidatura

Outras classes de software (i.e. Pure Fabrication) identificadas:

 * SeriarCandidaturasAnuncioTask
 * RegistoAnuncios
 * RegistoOrganizacao

###	Diagrama de Sequência

![UC13_SD.svg](UC13_SD.svg)


![UC13_SD_seriarCandidaturasSubmetidas.svg](UC13_SD_seriarCandidaturasSubmetidas.svg)


![UC13_SD_novoProcessoAtribuicao.svg](UC13_SD_novoProcessoAtribuicao.svg)

###	Diagrama de Classes

![CD_UCX.png](CD_UCX.png)

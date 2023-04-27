# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

	SprintA
* (Unregistered user) Display listed properties;
* (Agent)Publish sale annoucement;
* (System Administrator) Register employee;
* (Owner) Submit a request for announcement a property to an agent;
* (System administrator) Register a store;

* (Company employee) Publication of rental and sale advertisements;
* (Company employee) Registration of a business;
* (Company employee) Scheduling and registration of visits to the property;
* (Agent) Setting commission of the request by the owner;
* (Agent) Publishing the offer in the system;
* (Client) Requesting a visit to a real state agent for a specific property;
* (Agent) Sends a response about the visit to the client; 
* (Client) Accepts or rejects the visit and automatically schedule in the system;
* (Agent) Register a record of the visit;
* (Client) Request for purchase/lease of the property to the agent;
* (Agent) Accepts or rejects the purchase/lease request (if accepted remove from listed propeties);
* (System administrator) Registers all employees;
* (System administrator) Registers the branches of the network.



## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


**Error Prevention By the User**
* The agent must validate the request of rent or sell the property;
* If the request is a sale of a property the owner provides the information and the system must validate it. The type of property(apartment, house or land),the area in m2, the location, the distance of the center, the requested price, and one or more photographs;
* If the property is an apartment or a house, the system also must validate the number of bathrooms, parking spaces and the available equipment;
* The system must validate the name, citizen's card number, the tax number, the address, the email address, the phone number and the agency of a new employee registered by the system administrator; And the branches of the network (destination, location, and local manager).

**Interface aesthetics and design**
* When the app is initialized, shows a menu with 2 options; 1- The user can see the list of properties; 2- The user can login in the app;
* If the user choose option 1, he will see the list of properties availables;
* If the user choose option 2, the app identifies if the user is a client, an agent, an owner or a system administrator;
* In case the user is a system administrator, shows a sub-menu with the options of register a new employee, register a store, and specify districts, municipalities and parishes;
* In case the user is an owner, shows the option of submit a request for announcement a property sale or rent, choosing the responsible agent;
* In case the user is an agent, shows the option of publishing any a sale announcement on the system.



## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

**Frequency and severity of failure**
* This app is a "small" project, so we didn't predict any failure.

**Possibility of recovery**
* As recovery, we write in a file all the information introduced.



## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



(fill in here )


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
  

(fill in here )


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

-Must be developed in Java
-Must be developed using IntelliJ or NetBeans
-Interface must be developed in JavaFX 11



(fill in here )


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


(fill in here )

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )
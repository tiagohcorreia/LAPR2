# US 013 - List all employees

## 1. Requirements Engineering


### 1.1. User Story Description


As a network manager, I want to list all employees working in every store
of the network.

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>The manager of the network intends to analyse the performance of each of the branches and the
global behaviour of the network on a daily basis.


**From the client clarifications:**

>Question: Do you want a list where the header is ID, the name of the store, and the total number of listings that the store has?

>Answer: Yes.





### 1.3. Acceptance Criteria


* AC1. The list of employees should be alphabetically sorted and grouped by store.
* AC2. Stores should be sorted according to their property listings, from the one
with more listings to the one with less listings.
* AC3. Each store should state how many property listings it has.

### 1.4. Found out Dependencies

* Dependency to "US002 - Publish any sale announcement on the system" since there needs to exist annoucements for Acceptance Criteria 2 and 3(AC2 and AC3).
* Dependency to "US003 - Register a new Employee" since there needs to exist employees to list.
* Dependency to "US005 - Register a store" since there needs to exist a store for employees to be assigned.



### 1.5 Input and Output Data

**Output Data:**

* Sorted employee list

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

![System Sequence Diagram - Alternative One](svg/US013-SSD.svg)


# US 005 - Register a store

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a store.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The company's systems administrator will be responsible for registering the  branches of the network (specifying
the designation, the location, the email address and the contact telephone number) 


**From the client clarifications:**

>Question: Could you please share how will the designation of new stores be made, is there a pattern perhaps?

>Answer: There is no pattern. The System Administrator can introduce any designation/name. The designation/name should have at most forty characters.

>Question: Will the System Administrator be able to choose a location from a list of available locations (defined elsewhere in the application) or will he be able to submit any location he wants?

>Answer: The System Administrator can submit any location.




### 1.3. Acceptance Criteria


* AC1: All required fields must be filled in.
* AC2: ID must be an integer.
* AC3: Name should have at most 40 characters.

### 1.4. Found out Dependencies


* There is a dependency because user should be already authenticated.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a ID 
	* a designation/name 
	* a location
	* a phone number
	* a email address


**Output Data:**

* Store Card data
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

![System Sequence Diagram - Alternative One](svg/US005.svg)


# US 020 - As a client, I want to read the response for the appointment request, to accept or reject it

## 1. Requirements Engineering


### 1.1. User Story Description


As a client, I want to read the response for the appointment request, to accept or reject it


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**


>	


>	



**From the client clarifications:**

> **Question:** "The reason for declining the appointment should be selected from predefined options or entered as free text?"
>  
> **Answer:** "The message should be entered as free text."


> **Question:** 
>  
> **Answer:** 


### 1.3. Acceptance Criteria


* **AC1:** The agent must be notified when the message is displayed to the client
 
* **AC2:** The appointment request must provide information about the property and the date of the appointment
 
* **AC3:** When the appointment is rejected, the client must specify the reason

* **AC4:** The appointment request must provide the agent name and phone number


### 1.4. Found out Dependencies


* The system must have appointment request already registered


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
 

	* N/A 
	 

	
* Selected data:


	* appointment request


**Output Data:**

    *  Request confirmation
	*  Success of the operation

### 1.6. System Sequence Diagram (SSD)


![System Sequence Diagram](svg/us006-system-sequence-diagram-alternative-one.svg)


### 1.7 Other Relevant Remarks

* N/A
# US 014 - Appointment Request Response Management 

## 1. Requirements Engineering


### 1.1. User Story Description


As a client, I want to read the response for the appointment requests, to accept or reject it.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	"After consulting a list of properties, the client can request to schedule a visit to the real estate agent for a specific property to verify its conditions. 
    The agent receives the request, checks the availability and sends the response. If the customer accepts the order, it is automatically scheduled in the system." 


>	"When the client decides to buy/rent the property, he sends a request for the purchase/lease of the property to the agent. After being appreciated by the agent, he accepts or rejects the order. 
    If the request is accepted, the offer will not be shown again to clients using the application."

* Although this quote doesn't specifically mention appointment requests, it indicates that the client has the ability to reject an order or request related to buying or renting a property.

**From the client clarifications:**

> No client clarifications were found in the forum for this user case scenario.


### 1.3. Acceptance Criteria


* **AC1:** Appointment request responses should be sorted from the oldest to the newest.
* **AC2:** When an appointment request is accepted for a property, all other requests for the same property should be automatically rejected.
* **AC3:** When rejecting an appointment request, the client should be able to suggest a new date and time for the visit, thus triggering a new appointment request.


### 1.4. Found out Dependencies


* There is a dependency to "US009 Sends a message to schedule a visit" since a schedule visit has to be made first so it can get reviewed by an agent and accepted/rejected by the client.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a date, 
	* a time, 
	
* Selected data:
	* Appointment Requests List


**Output Data:**

* Message of the agent
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram](svg/SSD.svg)

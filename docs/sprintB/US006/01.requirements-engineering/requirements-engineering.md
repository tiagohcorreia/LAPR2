# US 006 - Specify states, Districts and Cities


## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to specify states, districts and cities in the system. 


### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

> All registered information, except the agency commission, can be accessed by the client who intends to buy or rent the property; the client is, then, responsible for being able to consult the properties by type, number of rooms, and sort by criteria such as price or the city where the property is located.
  The client is responsible for being able to consult the properties by type, number of rooms, and sort by criteria such as price or the parish where the property is located.
  From the client clarifications:


**From the client clarifications:**

> **Question:** In user story 006, it says "As a system administrator, I want to specify districts, municipalities, and parishes in the system." What is the purpose of this function, how does the system administrator intend to use the ability to specify different locations?
>
> Answer:  The goal is to specify in the system information that can be used/selected to fill the location of the property. An example of the store location is: 71 ST. NICHOLAS DRIVE, NORTH POLE, FAIRBANKS NORTH STAR, AK, 99705.
           For instance, if the information about the existing US states is specified in the system, then the user only selects AK and does not need to write this information.


### 1.3. Acceptance Criteria
•	**AC1:** A state must be created first before you can specify a district.
•	**AC2:** A district must be created first before you can specify a city.
•	**AC3:** A city must be created first before you can specify a street.


### 1.4. Found out Dependencies
*	No further dependencies were found for this US.


### 1.5 Input and Output Data
**Input Data:**
* Typed data:
  * Street
    City
	District
	State
	Zipcode
* Output Data:
  * Selecting a state
	Selecting a City
	Selecting a District
    
### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

### Alternative One

![System Sequence Diagram - Alternative One](svg/ssd.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.
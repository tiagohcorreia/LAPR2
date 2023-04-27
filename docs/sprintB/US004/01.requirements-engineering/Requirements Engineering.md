# US 004 - Listing a Property

## 1. Requirements Engineering


### 1.1. User Story Description

As an owner, I intend to submit a request for listing a property sale or rent,
choosing the responsible agent.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Owners go to one of the company's branches and meet with a real estate agent to sell or rent one or more properties

>	The type of property (apartment, house or land),
the area in m2, the location, the distance from the city centre, the requested price and one or more
photographs. If the property is an apartment or a house, the owner also provides: the number of
bedrooms, the number of bathrooms, the number of parking spaces and the available equipment,
such as central heating and/or air conditioning. In case the property is a house, the existence of a
basement, an inhabitable loft, and sun exposure must be registered as well.


**From the client clarifications:**

> **Question:** In the project description it is mentioned that in the case of a request for the sale of a property, the owner must provide "one or more photographs". Taking that into account, is there a maximum number of photos that can be submitted when publishing an announcement? If so, how many?
>  
> **Answer:** The maximum number of photos is 30.


> **Question:** Does the owner have a limit of requests they can do?
>  
> **Answer:** No.

> **Question:** Regarding the property’s photographs, is that considered selected data?
>
> **Answer:** The owner should input the URI of each file/photograph.
 
> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
>
> **Answer:** No.
 
 
> **Question:** According to the Project Description, the agent when selling a property can charge a flat price comission or a percentage of the sale value, my question here is wether there is a minimum and/or a maximum to each of these types of comissions?
>
> **Answer:** There is no maximum and the minimum is 0.


> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency,etc)?
>
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.


> **Question:** Does an owner need to be registered in the system to submit a request for a property listing?
>
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.

### 1.3. Acceptance Criteria


* **AC1:** All requested data must be filled (type of property, number of bedrooms, ...)
* **AC2:** The type of property only can be an apartment, house or land 
* **AC3:** A property and an announcement can't be duplicated
* **AC4:** Only can be submitted 30 photos with a minimum of 1 photograph
* **AC5:** The minimum of comission is 0% or 0€. There is no maximum.


### 1.4. Found out Dependencies


* No dependency were found.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* number of bedrooms
    * number of bathrooms
    * parking spaces
    * available equipment
    * existence of a basement
	* existence of an inhabitable loft
	* sun exposure
    * area in m2
    * distance of the centre 
    * price
    * photos
  
	
* Selected data:
    * location of the property
	* rent or sell a property
    * type of property (land, house or apartment)
    * responsible agent


**Output Data:**
* Agents List
* States, Districts and Cities
* Property data
* Responsible agent
* Sell Or Rent the property
* Price
* Success of the operation

### 1.6. System Sequence Diagram (SSD)

![SSD_04-US04___System_Sequence_Diagram__SSD_.svg](svg%2FSSD_04-US04___System_Sequence_Diagram__SSD_.svg)



### 1.7 Other Relevant Remarks

* N/A
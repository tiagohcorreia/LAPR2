# US 007 - As an unregistered user, I want to register in the system to buy, sell or rent properties 

## 1. Requirements Engineering


### 1.1. User Story Description


As an unregistered user, I want to register in the system to buy, sell or rent properties


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>Real Estate USA needs an application that enables buyers who visit its stores/agencies to access the
properties available for lease or sale, as well as the company’s employees to carry out a set of
operations related to the real estate business


**From the client clarifications:**

> **Question:** After the users fills all the required information, is the user automatically registered in the system, or is there any other role that will review and approve the user registration?
>  
> **Answer:** The system should automatically validate the registration.


> **Question:** When an unregistered user wants to register a new account in the system, the set of parameters that are asked are the following: name, citizen card number, tax number, email, phone number, and password. Do you want any extra parameters/requirements to be asked or just the ones specified above? If so, which ones are mandatory?
>  
> **Answer:** The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the contact telephone number. The address of the owner is not mandatory.

> **Question:** Does the user also receive the password via email or can he choose a password when registering?
>  
> **Answer:** The owner can choose a password when registering.


### 1.3. Acceptance Criteria


* **AC1:** User name, e-mail and password can't be empty
* **AC2:** E-mail must have @


### 1.4. Found out Dependencies


* N/A


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* user name
	* user e-mail
	* user password
	
	
* Selected data:
	* N/A


**Output Data:**

*  User data (name, e-mail and password)
*  Request confirmation
*  Success of the operation

### 1.6. System Sequence Diagram (SSD)


![System Sequence Diagram](C:\Users\tiago\ISEP\lei-23-2s-1dm-g61\docs\sprintB\US007\01.requirements-engineering\svg\SSD.svg)


### 1.7 Other Relevant Remarks

* N/A
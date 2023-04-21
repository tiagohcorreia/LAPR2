# US 004 - Listing a property request

## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID | Question: Which class is responsible for...   | Answer                     | Justification (with patterns)                                                                                 |
|:-------------  |:----------------------------------------------|:---------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 | 	... interacting with the actor?              | RegisterPropertyUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 | 	... coordinating the US?                     | RegisterEmployeeController | Controller                                                                                                    |
| 			  		 | 	... instantiating a new Property?            | Property                   |                                                                                                               |
| 			  		 | ... knowing the user using the system?        | UserSession                | IE: cf. A&A component documentation.                                                                          |
                                                                           |
| Step 2  		 | 							                                       |                            |                                                                                                               |
| Step 3  		 | 	...saving the inputted data?                 | Property                   | IE: object created in step 1 has its own data.                                                                |
| Step 4  		 | 	...knowing the task categories to show?      | System                     | IE: Task Categories are defined by the Administrators.                                                        |
| Step 5  		 | 	... saving the selected category?            | Eployee                    | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		 | 							                                       |                            |                                                                                                               |              
| Step 7  		 | 	... validating all data (local validation)?  | Task                       | IE: owns its data.                                                                                            | 
| 			  		 | 	... validating all data (global validation)? | Organization               | IE: knows all its tasks.                                                                                      | 
| 			  		 | 	... saving the created employee?             | Property                   | IE: owns all its tasks.                                                                                       | 
| Step 8  		 | 	... informing operation success?             | RegisterPropertyUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Property

Other software classes (i.e. Pure Fabrication) identified: 

 * RegisterPropertyUI  
 * RegisterPropertyController
 * PropertyRepository


## 3.2. Sequence Diagram (SD)

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![US004-SD.svg](svg%2FUS004-SD.svg)![Sequence Diagram - Full](svg/SD.svg)

## 3.3. Class Diagram (CD)

![US004-CD.svg](svg%2FUS004-CD.svg)![Class Diagram](svg/CD.svg)
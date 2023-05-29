# US 004 - Listing a property

## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID                                                   | Question: Which class is responsible for...               | Answer                     | Justification (with patterns)                                                                                 |
|:-----------------------------------------------------------------|:----------------------------------------------------------|:---------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1 - asks to publish an announcement                         | 	... interacting with the actor?                          | RegisterPropertyUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                                          | 	... coordinating the US?                                 | RegisterPropertyController | Controller                                                                                                    |
| 			  		                                                          | 	... instantiating a new Announcement?                    | Owner                      | Creator (Rule 1): in the DM, Agent publish an announcement.                                                   |
| 			  		                                                          | ... knowing the user using the system?                    | UserSession                | IE: cf. A&A component documentation.                                                                          |
| Step 2 - request data	                                           | 		... displaying the UI for the actor to input data?					 | RegisterPropertyUI         |                                                                                                               |
| Step 3 - select the property type		                              | 	...saving the selected property type??                   | Announcement               | IE: object created in step 1 is categorizaded into a property type.                                           |
| Step 4 - presents the data fields to be in by the property type	 | 	...presents the fields according to property type?       | Property                   |                                                                                                               |
| Step 5 - insert the requested data                               | 	...saving the inputted data?                             | Announcement               | IE: object created in step 1 has its own data.                                                                |
| Step 6 - validate data                                           | 	..					                                                  | Agent                      |                                                                                                               |              
| Step 7 - submit data		                                           | 	...validating the data locally (mandatory data)?         | Announcement               | IE: The object created has its own data.                                                                      | 
| 			  		                                                          | 	... validating all data (global validation)?             | AnnouncementRepository     | IE: knows all its announcements.                                                                              | 
| 			  		                                                          | 	... saving the created announcement?                     | AnnouncementRepository     | IE: owns all its announcements.                                                                               | 
| Step 8  - displays operation sucess	                             | 	... informing operation success?                         | RegisterPropertyUI         | Pure Fabrication.                                                                                             | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Property
 * Announcement

Other software classes (i.e. Pure Fabrication) identified: 

 * RegisterPropertyUI  
 * RegisterPropertyController
 * AnnouncementsRepository
 * Repositories
 * RegisterEmployeeRepository


## 3.2. Sequence Diagram (SD)

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![US004-SD.svg](svg%2FUS004-SD.svg)![Sequence Diagram - Full](svg/SD.svg)

## 3.3. Class Diagram (CD)

![US004-CD.svg](svg%2FUS004-CD.svg)![Class Diagram](svg/CD.svg)
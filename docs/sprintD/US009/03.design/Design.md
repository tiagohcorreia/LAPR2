# US 009 - Sends a message to schedule a visit

## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID         | Question: Which class is responsible for...            | Answer                  | Justification (with patterns)                                                                                                                                           |
|:-----------------------|:-------------------------------------------------------|:------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Step 1  		             | 	... interacting with the actor?                       | ScheduleVisitUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.                                                           |
| 			  		                | 	... coordinating the US?                              | ScheduleVisitController | Controller                                                                                                                                                              |
| 			  		                | 	... instantiating a new Schedule?                     | Schedule                | Creator                                                                                                                                                                 |
| Step 2	  		            | ...haveing the necessary atributes of the announcement | AnnouncementDTO         |                                                                                                                                                                         |
| 		                     | 	...convert announcements into DTO		                   | AnnouncementMapper      |                                                                                                                                                                         |
| 		                     | 	...saving announcementsDTO		                          | AnnouncementMapper      |                                                                                                                                                                         |
| Step 3  		             | 	...saving the inputted data?                          | Schedule                | IE: object created in step 1 has its own data.                                                                                                                          | 
| Step 5  		             | 	... saving the selected schedule?                     | Schedule                |                                                                                                                                                                         |
| Step 6  		             | 							                                                |                         |                                                                                                                                                                         |              
| Step 7  		             | 	... validating all data (local validation)?           | Schedule                | IE: owns its data.                                                                                                                                                      | 
| 			                    |
| 			  		                | 	... saving the created schedule request?              | ScheduleRepository      | IE: owns all its tasks.                                                                                                                                                 | 
| Step 8  		             | 	... informing operation success?                      | ScheduleUI              | IE: is responsible for user interactions.                                                                                                                               | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Schedule

Other software classes (i.e. Pure Fabrication) identified: 

 * ScheduleVisitUI  
 * ScheduleVisitController
 * ScheduleRepository
 * AnnouncementRepository
 * AnnouncementDTO
 * AnnouncementMapper


## 3.2. Sequence Diagram (SD)

![SD.svg](svg%2FSD.svg)

## 3.3. Class Diagram (CD)

![CD.svg](svg%2FCD.svg)
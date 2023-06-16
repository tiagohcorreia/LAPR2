# US 018 - Analyse the deals made, based on the characteristics of the property using simple liner regression and multilinear regression

# 4. Tests 

**Test 1:** Check if filters by houses and apartments orders 

	@Test
    void getApartmentsAndHouses() {
        List<Order> expectedHouseAndApartmentsList = new ArrayList<>();
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderHouse1 = new Order(123,DTOHouse);
        pt.ipp.isep.dei.esoft.project.domain.model.Order orderApartment1 = new Order(123,DTOApartment);
        expectedHouseAndApartmentsList.add(orderHouse1);
        expectedHouseAndApartmentsList.add(orderApartment1);

        List<Order> result= analyseDealsController.getApartmentsAndHouses();

        assertEquals(expectedHouseAndApartmentsList, result);


    }



*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class AnalyseDealsController 

```java
public Task createTask(String reference, String description, String informalDescription,
								 String technicalDescription, Integer duration, Double cost,
								 String taskCategoryDescription) {

	TaskCategory taskCategory = getTaskCategoryByDescription(taskCategoryDescription);

	Employee employee = getEmployeeFromSession();
	Organization organization = getOrganizationRepository().getOrganizationByEmployee(employee);

	newTask = organization.createTask(reference, description, informalDescription, technicalDescription, 
			duration, cost,taskCategory, employee);
    
	return newTask;
}
```


## Class Organization

```java
public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, Integer duration, Double cost,
                                     TaskCategory taskCategory, Employee employee) {
    
        Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                taskCategory, employee);

        addTask(task);
        
        return task;
    }
```

# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?






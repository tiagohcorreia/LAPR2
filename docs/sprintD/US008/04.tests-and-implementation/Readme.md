# US 006 - Accept/Reject Announcements Requests

# 4. Tests 

**Test 1:** Check the correct employee. 

	 @Test
    public void ensureGetEmployeeReturnsCorrectEmployee() {
        AnnouncementRequestsController controller = new AnnouncementRequestsController();
        String name = "John Doe";
        Employee expectedEmployee = new Employee(name);

        controller.employeeRepository.addEmployee(expectedEmployee);
        Employee actualEmployee = controller.getEmployee(name);

        Assert.assertEquals(expectedEmployee, actualEmployee);
    }




**Test 2:** Check that the employee exists. 

	@Test
    public void ensureIsEmployeeReturnsTrueForExistingEmployee() {
        AnnouncementRequestsController controller = new AnnouncementRequestsController();
        String agentName = "John Doe";
        Employee existingEmployee = new Employee(agentName);
        controller.employeeRepository.addEmployee(existingEmployee);

        boolean result = controller.isEmployee(agentName);

        Assert.assertTrue(result);
    }



# 5. Construction (Implementation)


## Class AnnouncementRequestController 

```java
 public List<AnnouncementRequestDTO> getAnnouncementRequests(Employee agent) {
        List<AnnouncementRequestDTO> requestsForAgent = new ArrayList<>();
        for (Announcement announcement : this.announcementRepository.getAllAnnouncements()) {
        if (announcement.getStatus() == AnnouncementStatus.REQUESTED && announcement.getAgent().equals(agent)) {
        AnnouncementRequestDTO dto = this.announcementRequestMapper.toDto(announcement);
        requestsForAgent.add(dto);
        }
        }

        Collections.sort(requestsForAgent, Comparator.comparing(AnnouncementRequestDTO::getDate).reversed());

        return requestsForAgent;
        }
```




# 6. Integration and Demo 

N/A

# 7. Observations

N/A





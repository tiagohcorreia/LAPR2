# US 012 - Import data from a legacy system

# 4. Tests
## 4.1. FileOps
### 4.1.1. readFile()
**Test 1:**  Check that readFile() works
```java
    @Test
    void ensureReadFileWorks() throws FileNotFoundException {
        //Act
        File resultFile = FileOps.readFile(CSV_FILE_FILEPATH);

        //Assert
        assertEquals(new File(CSV_FILE_FILEPATH), resultFile);
    }
```

**Test 2:** Check that readFile() throws a FileNotFound exception when the filepath doesn't point to an existing file
```java
    @Test
    void ensureReadFileThrowsFileNotFoundException(){
        //Act & Assert
        assertThrows(FileNotFoundException.class, () -> {
            File file = FileOps.readFile("testfile.example");
        });
    }
```

**Test 3:** Check that readFile() throws a InvalidArgumentException when the filepath doesn't point to a readable file
```java
    @Test
    void ensureReadFileThrowsInvalidArgumentException(){
        //Arrange
        String userDirectory = System.getProperty("user.dir");

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            File file = FileOps.readFile(userDirectory);
        });
    }
```

### 4.1.1. appendToFile()
**Test 1:**  Check that appendToFile() works
```java
    @Test
    void ensureAppendToFileWorks() throws IOException {
            //Arrange
            File f1 = new File(TEST_FILE_FILEPATH);
            File f2 = new File(TEST_FILE_2_FILEPATH);

            //Act
            FileOps.appendToFile(TEST_FILE_FILEPATH, "\n"+EXAMPLE_LINE_2);

            //Assert
            assertEquals(-1L, Files.mismatch(f1.toPath(), f2.toPath()));
    }
```

### 4.1.1. deleteFile()
**Test 1:**  Check that deleteFile() throws a FileNotFound exception when the filepath doesn't point to an existing file
```java
    @Test
    void ensureDeleteFileThrowsFileNotFoundException(){
            //Act & Assert
            assertThrows(FileNotFoundException.class, () -> FileOps.deleteFile(NONEXISTENT_FILE_FILEPATH));
    }
```

### 4.1.1 isFileEmpty()
**Test 1:**  Check that isFileEmpty() works
```java
    @Test
    void ensureIsFileEmptyWorks(){
            //Act & Assert
            assertTrue(FileOps.isFileEmpty(new File(EMPTY_CSV_FILE_FILEPATH)));
    }
```

## 4.2. CsvHandlerTest

### 4.2.1. readCsv()
**Test 1:**  Check that readCsv() works
```java
    @Test
    void ensureReadCSVWorks() throws InvalidFileTypeException {
        //Arrange
        File csvFile = new File(CSV_FILE_FILEPATH);
        List<?> dataWithoutHeader = this.data.subList(1,this.data.size());

        //Act & Assert
        assertEquals(dataWithoutHeader,CsvHandler.getDataFromCsvFile(csvFile));
    }
```

**Test 2:**  Check that readCsv() throws InvalidFileTypeException when the filename doesn't end with ".csv"
```java
    @Test
    void ensureReadCSVThrowsInvalidFileTypeException() throws FileNotFoundException {
            //Arrange
            FileOps.createFile(TEST_FILE_FILEPATH,"This is a, test file!");
            File file = FileOps.readFile(TEST_FILE_FILEPATH);

            //Act & Assert
            assertThrows(InvalidFileTypeException.class, () -> {
                List<?> csv = CsvHandler.getDataFromCsvFile(file);
            });
    }
```
### 4.2.2. csvIsEmpty()
**Test 1:**  Check that csvIsEmpty() throws IllegalArgumentException when the provided list is empty
```java
    @Test
    void ensureCsvIsEmptyThrowsIllegalArgumentException() {
        //Arrange
        List<?> csv = new ArrayList<>();

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            CsvHandler.csvIsEmpty(csv);
        });
    }
```
# 5. Construction (Implementation)
[//]:TODO


# ---------------- v <u>TEMPLATE</u> v ----------------
# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Task instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Task class with a reference containing less than five chars - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		Category cat = new Category(10, "Category 10");
		
		Task instance = new Task("Ab1", "Task Description", "Informal Data", "Technical Data", 3, 3780, cat);
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class CreateTaskController 

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






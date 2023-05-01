# US 006 - To create a Task 

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowed() {
        Location instance = new Location(null, null, null, null, null);
    }
	

**Test 2:** Check that the zipcode has to be only 5 numbers. 

	@Test
    public void ensureZipCodeIsValid() {
        Location instance = new Location("123 Main St", "AnyCity", "District", "AK", "90210");
        assertEquals("90210", instance.getZipCode());
    }


**Test 3:** Test to check there is only a 2 letter capital abreviation of the USA state. 

    @Test
    public void testStateFormat() {
        String state = "NY";
        boolean isValid = getState.matches("^[A-Z]{2}$");
        assertTrue(isValid);
    }
	
	
**Test 4:** Test to unsure the city has more then 3 characters. 

    @Test
    public void testCityNameLength() {
        Location location = new Location("123 Main St", "AnyCity", "District", "AK", "90210");
        String city = location.getCity();
        assertTrue(City.length() > 3);
    }	
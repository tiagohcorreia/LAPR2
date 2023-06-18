# US 019 - Optimal Partition 

# 4. Tests 

**Test 1:** Check if the input file is not empty. 

    @Test
    public void testFileNotEmpty() {
        File file = new File("filePath");
        
        assertTrue(isFileNotEmpty(file), "File is not empty");
    }

    private boolean isFileNotEmpty(File file) {
        return file.exists() && file.isFile() && file.length() > 0;
    }
}
	

**Test 2:** Multiple tests for the brute force algorithm - AC3. 

	 @Test
    public void testAlgorithmWithThreeStores() {
        int maxStores = 3;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithSixStores() {
        int maxStores = 6;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithNineStores() {
        int maxStores = 9;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithTwelveStores() {
        int maxStores = 12;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithFifteenStores() {
        int maxStores = 15;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithEighteenStores() {
        int maxStores = 18;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithTwentyOneStores() {
        int maxStores = 21;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithTwentyFourStores() {
        int maxStores = 24;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithTwentySevenStores() {
        int maxStores = 27;
        US19.TestAlgorithm(filePath,maxStores);
    }

    @Test
    public void testAlgorithmWithThirtyStores() {
        int maxStores = 30;
        US19.TestAlgorithm(filePath,maxStores);
    }


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class Optimal Partition 

```java
public static void OptimalPartition(numStores,storeCounts)
int minDifference = Integer.MAX_VALUE;
        List<Integer> minPartition = new ArrayList<>();

        int numStores = storeCounts.size();
        int numPartitions = numStores / 2;
        long totalCombinations = 1L << numStores;

        for (int i = 1; i < totalCombinations; i++) {
            if (Integer.bitCount(i) == numPartitions) {
                List<Integer> partition = new ArrayList<>();
                int count = 0;

                for (int j = 0; j < numStores; j++) {
                    if (((i >> j) & 1) == 1) {
                        partition.add(j);
                        count++;
                    }
                }

                if (count == numPartitions) {
                    int sum1 = 0;
                    int sum2 = 0;

                    List<Integer> sublist1 = new ArrayList<>();
                    List<Integer> sublist2 = new ArrayList<>();

                    for (int storeId = 0; storeId < numStores; storeId++) {
                        int propertiesCount = storeCounts.get(storeId);
                        if (partition.contains(storeId)) {
                            sublist1.add(propertiesCount);
                            sum1 += propertiesCount;
                        } else {
                            sublist2.add(propertiesCount);
                            sum2 += propertiesCount;
                        }
                    }

                    int difference = Math.abs(sum1 - sum2);

                    if (difference < minDifference) {
                        minDifference = difference;
                        minPartition = new ArrayList<>(partition);
                    }
                }
            }
        }
        System.out.printf("Input size: %d\n",numStores-1);

        System.out.println("Sublist 1:");
        int count = 0;
        for (int storeId : minPartition) {
            if (storeCounts.get(storeId) != 0) {
                System.out.println("(" + storeId + ", " + storeCounts.get(storeId) + ")");
                count++;
            }
        }

        while (count < numStores - 1) {
            System.out.println("(" + "0 " + ", 0)");
            count++;
        }

        System.out.println("Sublist 2:");
        count = 0;
        for (int storeId = 0; storeId < numStores; storeId++) {
            if (!minPartition.contains(storeId) && storeCounts.get(storeId) != 0) {
                System.out.println("(" + storeId + ", " + storeCounts.get(storeId) + ")");
                count++;
            }
        }

        while (count < numStores - 1) {
            System.out.println("(" + "0 " + ", 0)");
            count++;
        }

        System.out.println("Difference: " + minDifference);

        long endTime = System.currentTimeMillis();


        long runtime = endTime - startTime;


        System.out.println("Runtime: " + runtime + " milliseconds"); }
```


## LegacyCsvReader

```java
public static void LegacyCsvReader(String filePath) {
        long startTime = System.currentTimeMillis();;
        List<Integer> storeCounts = new ArrayList<>();
        int totalProperties = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            scanner.useDelimiter(";");

            int storeIdColumnIndex = 25;

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                String[] columns = line.split(";");

                if (columns.length > storeIdColumnIndex) {
                    int storeId = Integer.parseInt(columns[storeIdColumnIndex]);

                    while (storeCounts.size() <= storeId) {
                        storeCounts.add(0);
                    }
                    storeCounts.set(storeId, storeCounts.get(storeId) + 1);
                    totalProperties++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```







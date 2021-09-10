# Pagination Helper
We are going to create a PaginationHelper class to use in UI components.
And we are going to create Unit testing to test the class to make sure it is working.
 
## Running the code
This project created on Java + Maven + Cucumber BDD
To run the project:
####Step 1: This step will pull the project from Github Repo
```
git pull <githubRepo>
```
####Step 2: This step will compile the MVN repo and will generate the jar file
````
mvn clean verify
mvn clean test
````
When you run the code, first it will delete the target folder and will run the conde after build.
You can run the code in test or verify cyle. <br>
In verify it will generate the Cucumber HTML report under resource folder.<br><br>
You can run the code directly from Feature file or from Runner class.
````
Feature: Verify the pagination

  Scenario: Verify the pagination function as expected
    Given Use the List of Content pagination and Number of Item each page
      | List of Content | Number of Item each page |
      | abcdef          | 4                        |

    Then Get the Item Count
    Then Get the Page Count
    Then Get the Page Item Count
    Then Get the Page Index
````
Steps are clear enough to understand. <br>
Step 1 :  We get the test data which we need to test and giving the value of how many item 
for each page we want to place. <br>
Step 2 : we get the count of the letters and print them.<br>
Step 3 : We get the number of page generated for this test data.<br>
Step 4 : We are checking the number of items for each page. <br>
Step 5: We are checking the items location based on the index.<br>

##Implementation
````
public class PaginationSteps {
	int count;
	Logger logger = LoggerFactory.getLogger(PaginationSteps.class);
	@Given("Use the List of Content pagination and Number of Item each page")
	public void useTheListOfContentPaginationAndNumberOfItemEachPage(DataTable dataTable) {
		count = Integer.parseInt(dataTable.asLists().get(1).get(1));
		PaginationHelperTest.setList(dataTable.asLists().get(1).get(0));
		PaginationHelperTest.getStringList();

	}

	@Then("Get the Item Count")
	public void getTheItemCount() {
		logger.info("==== Items are counting ====...");
		PaginationHelperTest.setHelper(new PaginationHelper(PaginationHelperTest.getStringList(), count));
		new PaginationHelperTest().getItemCount();

	}

	@Then("Get the Page Count")
	public void getThePageCount() {
		logger.info("==== Getting the Page count ====...");
		new PaginationHelperTest().getPageCount();
	}

	@Then("Get the Page Item Count")
	public void getPageTheItemCount() {
		logger.info("==== Getting page item count ====...");
		new PaginationHelperTest().getPageItemCount();
	}

	@Then("Get the Page Index")
	public void getThePageIndex() {
		logger.info("==== Getting page index ====...");
		new PaginationHelperTest().getPageIndex();
	}

````
We use PaginationSteps class as a bridge between main methods and the feature file.<br>
Most of the time we prefer not to put any code which might change in feature.
<br>
## PaginationHelper.java
````
public class PaginationHelper<T> {

    public List<T> listOfCollection;
    public int itemsPerPage;

    public PaginationHelper(List<T> listOfCollection, int itemsPerPage) {
        this.listOfCollection=listOfCollection;
        this.itemsPerPage=itemsPerPage;
    }

    public int itemCount() {
        return listOfCollection.size();
    }

    public int pageCount() {
        int len = listOfCollection.size();
        int page = len%itemsPerPage;
        int pages = 0;
        if(page != 0){
            pages = len/itemsPerPage +1;
        }else{
            pages = len/itemsPerPage;
        }
        return pages;
    }

    public int pageItemCount(int pageIndex) {
        int pages = this.pageCount();
        int len = listOfCollection.size();
        int page = len%itemsPerPage;
        if(pageIndex<0 || pageIndex>=pages){
            return -1;
        }
        else{
            if(page !=0 && pageIndex==pages-1){
                return page;
            }else{
                return itemsPerPage;
            }
        }
    }

    public int pageIndex(int itemIndex) {
        int len = listOfCollection.size();
        if(itemIndex<=len && itemIndex >0){
            return itemIndex / itemsPerPage;
        }else{
            return -1;
        }
    }
}
````
In this class we implemented the main logic for all calculations. 
And used below methods for implementation<br>
 public int itemCount() <br>
 public int pageCount() <br>
 public int pageItemCount(int pageIndex)<br>
 public int pageIndex(int itemIndex)<br>
 
 ##Testing
 For testing, we created another method called PaginationHelperTest.java<br>
 As much as possible I put comments in all methods.<br>
 We created getter and setter methods for required fields.<br>
 And I guess inside the class explanation is enough to understand.
 ````
public class PaginationHelperTest {
    Logger logger = LoggerFactory.getLogger(PaginationHelperTest.class);
    public static PaginationHelper helper;
    public static String list;


    public static String getList() {
        return list;
    }

    public static void setList(String list) {
        PaginationHelperTest.list = list;
    }

    public static PaginationHelper getHelper() {
        return helper;
    }

    public static void setHelper(PaginationHelper helper) {
        PaginationHelperTest.helper = helper;
    }

    /**
     * Converting String to a list
     * Step 1
     */
    public static List<String> getStringList() {
        char[] ch = getList().toCharArray();
        List<String> list=new ArrayList<>();
        for (char c : ch) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    /**
     *Getting the list count
     * Step 2
     */
    public void getItemCount() {
        logger.info("Number of count {} ",getHelper().itemCount());
        Assert.assertEquals(6,getHelper().itemCount());
        logger.info("Assertion successful");
    }

    /**
     * Counting the number of page
     * Step 3
     */
    public void getPageCount() {
        logger.info("Number of page count {}",getHelper().pageCount());
        Assert.assertEquals(2,getHelper().pageCount());
        logger.info("Assertion successful");
    }

    /**
     * Calculating the number of items in each page
     * Step 4
     */
    public void getPageItemCount() {
        logger.info("Page Item Count for {} is {}",0,getHelper().pageItemCount(0));
        logger.info("Page Item Count for {} is {}",1, getHelper().pageItemCount(1));
        logger.info("Page Item Count for {} is {}",2, getHelper().pageItemCount(2));
        Assert.assertEquals(4,getHelper().pageItemCount(0));
        Assert.assertEquals(2,getHelper().pageItemCount(1));
        Assert.assertEquals(-1,getHelper().pageItemCount(2));
        logger.info("Assertion successful");
    }

    /**
     * Finding the item location based on index
     * Step 5
     */
    public void getPageIndex() {

        logger.info("Page item idex {} and the returned page is {}",5,getHelper().pageIndex(5));
        logger.info("Page item idex {} and the returned page is {}",2,getHelper().pageIndex(2));
        logger.info("Page item idex {} and the returned page is {}",20,getHelper().pageIndex(20));
        logger.info("Page item idex {} and the returned page is {}",-10,getHelper().pageIndex(-10));
        Assert.assertEquals(1,getHelper().pageIndex(5));
        Assert.assertEquals(0,getHelper().pageIndex(2));
        Assert.assertEquals(-1,getHelper().pageIndex(20));
        Assert.assertEquals(-1,getHelper().pageIndex(-10));
        logger.info("Assertion successful");

    }

}
`````

##Dependencies (POM.xml File)
You can find the full pom file in below.<br>
##Dependencies Used:
1 - Cucumber-Java and Cucumber-JUnit : This 2 needs to be same version. <br>
2 - slf4j and ch.qos.logback : You need to use the second dependency to avoid the binding errors. <br>
This dependency is used to create simple logger for the project.<br>
3- Maven Surefire plugin and net.masterthought plugin used to create colorful html report.
````
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>PaginationProject</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>5.7.0</version>
        </dependency>
        <!-- both up and down dependency should be the same version. -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>5.7.0</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.30</version>
            <scope>compile</scope>
        </dependency>
        <!--To avoid no-operation logger implementation error. we need below dep. -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M3</version>
                <configuration>
                    <includes>
                        <include>**/*.java</include>
                    </includes>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>3.10.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>package</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>AutoTraders.com Smoke Test</projectName>
                            <outputDirectory>${project.basedir}/src/test/resources/myReports</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                        </configuration>
                    </execution>

                </executions>
            </plugin>
        </plugins>
    </build>
</project>
````
##Reporting
As mentioned above, I used <b>net.masterthought</b> plugin to create the HTML report.<br>
Report you can find in <b>"src/test/resources/myReports/cucumber-html-reports"</b><br>
You can change the path as per your wish. 
###Changing the report path:
````
<configuration>
        <projectName>AutoTraders.com Smoke Test</projectName>
        <outputDirectory>${project.basedir}/src/test/resources/myReports</outputDirectory>
       <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
</configuration>
````
You can change in 2 way:
1-) Using <b>${project.basedir}</b> : This will give you the project's base path. You can add remaining path based on your wishes <br>
2-) Using <b>${project.build.directory}</b> : This will create the project under target folder. <br>
You can change the <outputDirectory> location based on your wish.<br>
The <cucumberOutput> is the location of the json file generated after test phase running. Your report will use this 
info to generate the report. To generate this you need to run the Runner.java class.

##Thanks
 

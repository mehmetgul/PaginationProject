package assessment.stepDef;

import assessment.PaginationHelper;
import assessment.PaginationHelperTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

}

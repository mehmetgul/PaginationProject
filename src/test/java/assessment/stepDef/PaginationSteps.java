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

	@Given("Use the {string} pagination and {string}")
	public void useThePaginationAnd(String content, String pageNum) {
		count = Integer.parseInt(pageNum);
		PaginationHelperTest.setList(content);
		PaginationHelperTest.getStringList();

	}

	@Then("Get the Item Count and compare with expected {string}")
	public void getTheItemCountAndCompareWithExpected(String itemCount) {
		logger.info("==== Items are counting ====...");
		PaginationHelperTest.setHelper(new PaginationHelper(PaginationHelperTest.getStringList(), count));
		new PaginationHelperTest().getItemCount(Integer.parseInt(itemCount));
	}

	@Then("Get the Page Count and compare with expected {string}")
	public void getThePageCountAndCompareWithExpected(String pageCount) {
		logger.info("==== Getting the Page count ====...");
		new PaginationHelperTest().getPageCount(Integer.parseInt(pageCount));
	}

	@Then("Get the Page Index and compare with Item Count")
	public void getTheAndCompareWith(DataTable dataTable) {
		logger.info("==== Getting page item count ====...");
		new PaginationHelperTest().getPageItemCount(dataTable);
	}

	@Then("Get the Item Index and compare the Expected Page Index")
	public void getTheAndCompareThe(DataTable dataTable) {
		logger.info("==== Getting page index ====...");
		new PaginationHelperTest().getPageIndex(dataTable);

	}
}

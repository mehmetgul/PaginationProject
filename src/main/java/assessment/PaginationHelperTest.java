package assessment;


import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


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
    public void getItemCount(int itemCount) {
        logger.info("Number of count is {} and expected count is {} ",getHelper().itemCount(),itemCount);
        Assert.assertEquals(itemCount,getHelper().itemCount());
        logger.info("Assertion successful");
    }

    /**
     * Counting the number of page
     * Step 3
     */
    public void getPageCount(int pageCount) {
        logger.info("Number of page count is {} and expected page count is {}",getHelper().pageCount(),pageCount);
        Assert.assertEquals(pageCount,getHelper().pageCount());
        logger.info("Assertion successful");
    }

    /**
     * Calculating the number of items in each page
     * Step 4
     */
    public void getPageItemCount(DataTable dataTable) {
        List<List<String>> rows= dataTable.asLists(String.class);
        for(int i=1;i<rows.size();i++){
            logger.info("Page Item Count for {} is {}",rows.get(i).get(0),getHelper().pageItemCount(Integer.parseInt(rows.get(i).get(0))));
            Assert.assertEquals(Integer.parseInt(rows.get(i).get(1)),getHelper().pageItemCount(Integer.parseInt(rows.get(i).get(0))));
        }
        logger.info("Assertion successful");
    }

    /**
     * Finding the item location based on index
     * Step 5
     */
    public void getPageIndex(DataTable dataTable) {
        List<List<String>> rows= dataTable.asLists(String.class);
        for(int i=1;i<rows.size();i++){
            logger.info("Page Item Index for {} is {}",rows.get(i).get(0),getHelper().pageIndex(Integer.parseInt(rows.get(i).get(0))));
            Assert.assertEquals(Integer.parseInt(rows.get(i).get(1)),getHelper().pageIndex(Integer.parseInt(rows.get(i).get(0))));
        }
        logger.info("Assertion successful");


    }

}

package assessment;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

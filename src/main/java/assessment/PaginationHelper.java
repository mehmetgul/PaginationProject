package assessment;

import java.util.List;

//

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
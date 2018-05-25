package constant.tools.web.result;

import java.io.Serializable;

public class Paging implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 100887231529313093L;

    private Integer           pageSize         = 10;

    private Integer           currentPage      = 1;

    private Integer           start            = 0;

    private Integer           total            = 0;

    private Integer           totalPages       = 0;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (null == pageSize || pageSize.intValue() < 0) {
            return;
        }
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (null == currentPage || currentPage.intValue() < 1) {
            return;
        }
        this.currentPage = currentPage;
    }

    public Integer getStart() {
        if (null != currentPage && null != pageSize) {
            start = (currentPage - 1) * pageSize;
        }
        if (start < 0) {
            start = 0;
        }
        return start;
    }

    public void setStart(Integer start) {
        if (null == start || start.intValue() < 0) {
            return;
        }
        this.start = start;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if (null == total || total.intValue() < 0) {
            return;
        }
        if (null == totalPages || totalPages == 0) {
            if (null != pageSize) {
                totalPages = (total + pageSize - 1) / pageSize;
            }
        }
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

}

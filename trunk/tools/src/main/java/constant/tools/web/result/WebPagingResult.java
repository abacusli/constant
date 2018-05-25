package constant.tools.web.result;

public class WebPagingResult<T> extends WebResult<T> {

    /**
     * 
     */
    private static final long serialVersionUID = -7640146370855569497L;

    private Paging            paging;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}

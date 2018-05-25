package constant.tools.web.result;

import java.io.Serializable;
import java.util.List;

public class WebResult<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3482766108109960123L;

    public static final int   SUCCESS          = 1;

    public static final int   FAILURE          = 0;

    private Integer           status           = WebResult.FAILURE;

    private String            code;

    private String            message;

    private T                 result;

    private List<WebFailure>  failures;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<WebFailure> getFailures() {
        return failures;
    }

    public void setFailures(List<WebFailure> failures) {
        this.failures = failures;
    }

}

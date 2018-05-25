package constant.tools.web.result;

import java.io.Serializable;

public class WebFailure implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 9135215743237779561L;

    private String            code;

    private String            message;

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
}

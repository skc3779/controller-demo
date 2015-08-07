package comm.data;

/**
 * Created by skc37_000 on 2015-08-07.
 */

import java.io.Serializable;
import java.util.Date;

public class ResultData implements  Serializable {
    private static final long serialVersionUID = 7763833945354654830L;
    private static final String ERROR_DATA = "";

    private boolean ok;
    private String message;
    private final Date date;
    public Object data;
    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public ResultData() {
        date = new Date();
    }

    public ResultData(Exception ex) {
        date = new Date();
        message = ex.getMessage();
        data = ERROR_DATA;
        ok = false;
    }

    public ResultData(Object data) {
        ok = true;
        date = new Date();
        message = "api call completed";
        this.data = data;
    }
}

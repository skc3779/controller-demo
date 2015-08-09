package comm.except;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by seokangchun on 15. 8. 9..
 */
@SuppressWarnings("serial")
public class BusinessException extends NestedRuntimeException {
    public BusinessException(Throwable cause) {
        super(String.valueOf(cause));
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
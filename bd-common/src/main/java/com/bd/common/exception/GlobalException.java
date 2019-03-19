package com.bd.common.exception;

/**
 * @author luxuewei
 * @since 2019/3/4
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}

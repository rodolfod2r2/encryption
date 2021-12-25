package org.framework.rodolfo.freire.git.encryption.core.util.exceptions;

public class ExceptionUtil extends CustomAbstractException {

    public ExceptionUtil() {

    }

    public ExceptionUtil(String message) {
        super(message);
    }

    public ExceptionUtil(Throwable cause) {
        super(cause);
    }

    public ExceptionUtil(String message, Throwable cause) {
        super(message, cause);
    }
}

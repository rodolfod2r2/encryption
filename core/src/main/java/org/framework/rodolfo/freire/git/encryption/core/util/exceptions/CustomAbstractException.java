package org.framework.rodolfo.freire.git.encryption.core.util.exceptions;

public abstract class CustomAbstractException extends RuntimeException {

    public CustomAbstractException() {

    }

    public CustomAbstractException(String message) {
        super(message);
    }

    public CustomAbstractException(Throwable cause) {
        super(cause);
    }

    public CustomAbstractException(String message, Throwable cause) {
        super(message, cause);
    }

}

package klapertart.lab.toko.messages;

import java.util.Map;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */
public class ResponseError extends ResponseGeneric{
    private Map<String,String> errors;

    public ResponseError(int status, String message, Map<String,String> errors) {
        super(status, message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

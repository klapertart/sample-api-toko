package klapertart.lab.toko.messages;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

public class ResponseSuccess<T> extends ResponseGeneric{
    private List<T> data;

    public ResponseSuccess(int status, String message, List<T> data) {
        super(status, message);
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

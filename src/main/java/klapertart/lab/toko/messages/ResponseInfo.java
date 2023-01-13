package klapertart.lab.toko.messages;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

public class ResponseInfo extends ResponseGeneric{
    List<String> info;

    public ResponseInfo(int status, String message, List<String> info){
        super(status,message);
        this.info = info;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }
}

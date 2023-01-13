package klapertart.lab.toko.messages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

public class ResponseUtil {
    public static ResponseEntity<ResponseGeneric> notFound(){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseGeneric(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()));
    }

    public static ResponseEntity<ResponseGeneric> success(){
        return ResponseEntity.ok(new ResponseGeneric(HttpStatus.OK.value(),HttpStatus.OK.toString()));
    }
}

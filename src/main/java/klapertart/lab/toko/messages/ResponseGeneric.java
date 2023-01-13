package klapertart.lab.toko.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Data
@AllArgsConstructor
public class ResponseGeneric {
    private int status;
    private String message;
}

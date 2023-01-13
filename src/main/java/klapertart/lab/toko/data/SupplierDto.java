package klapertart.lab.toko.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author kurakuraninja
 * @since 11/01/23
 */

@Data
public class SupplierDto {
    @NotEmpty
    @JsonProperty("productId")
    private String productId;

    @NotEmpty
    @JsonProperty("supplierId")
    private String supplierId;
}

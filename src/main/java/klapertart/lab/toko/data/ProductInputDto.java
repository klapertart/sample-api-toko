package klapertart.lab.toko.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Data
public class ProductInputDto {

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotNull
    @DecimalMin(value = "1.0", message = "Please Enter a valid price")
    private Double price;

    @NotEmpty
    @JsonProperty("categoryId")
    private String categoryId;
}

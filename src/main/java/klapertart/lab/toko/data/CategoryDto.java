package klapertart.lab.toko.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author kurakuraninja
 * @since 16/01/23
 */

@Data
public class CategoryDto {
    @JsonProperty("name")
    @NotEmpty
    private String name;
}

package klapertart.lab.toko.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author kurakuraninja
 * @since 14/01/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("email")
    @NotEmpty
    @Email
    private String email;

    @JsonProperty("fullName")
    @NotEmpty
    private String fullName;

    @JsonProperty("password")
    @NotEmpty
    private String password;

    @JsonProperty("userRole")
    @NotEmpty
    private String userRole;
}

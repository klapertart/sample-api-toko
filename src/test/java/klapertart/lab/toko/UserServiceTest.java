package klapertart.lab.toko;

import klapertart.lab.toko.data.UserRole;
import klapertart.lab.toko.entities.User;
import klapertart.lab.toko.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kurakuraninja
 * @since 13/01/23
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testSave() {
        User user = User.builder()
                .email("otong@spring.com")
                .fullName("otong sunandar")
                .password("123")
                .userRole(UserRole.USER)
                .build();

        userService.registerUser(user);

        Assertions.assertEquals(1, userService.countUser());
    }
}

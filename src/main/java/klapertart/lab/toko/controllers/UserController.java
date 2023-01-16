package klapertart.lab.toko.controllers;

import klapertart.lab.toko.data.UserDto;
import klapertart.lab.toko.data.UserRole;
import klapertart.lab.toko.entities.User;
import klapertart.lab.toko.messages.ResponseError;
import klapertart.lab.toko.messages.ResponseGeneric;
import klapertart.lab.toko.messages.ResponseSuccess;
import klapertart.lab.toko.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kurakuraninja
 * @since 14/01/23
 */

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/register")
    public ResponseEntity<ResponseGeneric> register(@Valid @RequestBody UserDto userDto){
        if(!userDto.getUserRole().toUpperCase().equals(UserRole.USER.name())&&!userDto.getUserRole().toUpperCase().equals(UserRole.ADMIN.name())){
            Map<String,String> errors = new HashMap<>();
            errors.put("userRole","invalid (use USER|ADMIN)");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errors));
        }

        User user = modelMapper.map(userDto, User.class);
        User userCreated = userService.registerUser(user);

        return ResponseEntity.ok(new ResponseGeneric(HttpStatus.OK.value(), HttpStatus.OK.name()));
    }
}

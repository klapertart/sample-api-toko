package klapertart.lab.toko.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@RestController
@RequestMapping("/api/welcome")
public class MainController {

    @GetMapping
    public String welcome(){
        return "Welcome APi Spring Data";
    }
}

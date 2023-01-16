package klapertart.lab.toko.services;

import klapertart.lab.toko.entities.User;
import klapertart.lab.toko.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author kurakuraninja
 * @since 13/01/23
 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found",email)));
    }

    public User registerUser(User user){
        boolean isUserExist = repository.findByEmail(user.getEmail()).isPresent();
        if(isUserExist){
            throw new RuntimeException(String.format("User with email %s already exist",user.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return repository.save(user);
    }

    public long countUser(){
        return repository.count();
    }
}

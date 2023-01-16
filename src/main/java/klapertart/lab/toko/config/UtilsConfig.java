package klapertart.lab.toko.config;

import klapertart.lab.toko.utils.AuditorImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author kurakuraninja
 * @since 14/01/23
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class UtilsConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorImpl();
    }
}

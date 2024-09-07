package com.spring.springsecurity.configs;

import com.spring.springsecurity.entities.User;
import com.spring.springsecurity.enums.Role;
import com.spring.springsecurity.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
          if (userRepository.findByEmail("admin@spring.security.com").isEmpty()){
              var roles = new HashSet<String>();
              roles.add(Role.ADMIN.name());
              User user = User.builder()
                      .email("admin@spring.security.com")
                      .password(passwordEncoder.encode("123456"))
                      .roles(roles)
                      .build();

              userRepository.save(user);
              log.warn("Admin created! Password default: 123456, please change it!");
          }
        };

    }
}

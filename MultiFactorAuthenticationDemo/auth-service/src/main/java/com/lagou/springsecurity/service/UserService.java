package com.lagou.springsecurity.service;

import com.lagou.springsecurity.domain.AuthCode;
import com.lagou.springsecurity.domain.User;
import com.lagou.springsecurity.repository.AutoCodeRepository;
import com.lagou.springsecurity.repository.UserRepository;
import com.lagou.springsecurity.util.GenerateCodeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AutoCodeRepository autoCodeRepository;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void auth(User user) {
        Optional<User> o =
                userRepository.findUserByUsername(user.getUsername());

        if(o.isPresent()) {
            User u = o.get();
            if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                generateOrRenewAutoCode(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }

    public boolean check(AuthCode authCodeToValidate) {
        Optional<AuthCode> authCode = autoCodeRepository.findAuthCodeByUsername(authCodeToValidate.getUsername());
        if (authCode.isPresent()) {
            AuthCode authCodeInStore = authCode.get();
            if (authCodeToValidate.getCode().equals(authCodeInStore.getCode())) {
                return true;
            }
        }

        return false;
    }

    private void generateOrRenewAutoCode(User u) {
        String generatedCode = GenerateCodeUtil.generateCode();

        Optional<AuthCode> autoCode = autoCodeRepository.findAuthCodeByUsername(u.getUsername());
        if (autoCode.isPresent()) {//?????????????????????????????????????????????
            AuthCode code = autoCode.get();
            code.setCode(generatedCode);
        } else {//?????????????????????????????????????????????????????????????????????
            AuthCode code = new AuthCode();
            code.setUsername(u.getUsername());
            code.setCode(generatedCode);
            autoCodeRepository.save(code);
        }
    }

}

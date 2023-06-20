package com.wendellemos.hroauth.services;

import com.wendellemos.hroauth.entities.User;
import com.wendellemos.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("E-mail not found " + email);
            throw new IllegalArgumentException("E-mail not found");
        }
        logger.info("E-mail found " + email);
        return user;
    }
}

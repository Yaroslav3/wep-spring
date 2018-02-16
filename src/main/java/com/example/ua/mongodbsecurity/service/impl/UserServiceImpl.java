package com.example.ua.mongodbsecurity.service.impl;

import com.example.ua.mongodbsecurity.model.User;
import com.example.ua.mongodbsecurity.persistens.UserDao;
import com.example.ua.mongodbsecurity.service.UserService;
import com.sun.istack.internal.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user" + username + "was not found!"));
    }

    @Override
    public Optional<User> findById(@NotNull ObjectId id) {
        return userDao.findById(id);
    }
}
//    @PostConstruct
//    public void init() {
////        userDao.findByUsername("user").ifPresent(user -> {
////            user.setPassword(new BCryptPasswordEncoder().encode("password"));
////            userDao.save(user);
////        });
////
////        if (!userDao.findByUsername("admin").isPresent()) {
////            userDao.save(User.builder()
////                    .username("admin")
////                    .password(new BCryptPasswordEncoder().encode("admin"))
////                    .authorities(ImmutableList.of(Role.USER))
////                    .accountNonLocked(true)
////                    .accountNonExpired(true)
////                    .credentialsNonExpired(true)
////                    .enabled(true)
////                    .build());
////        }
////        if (!userDao.findByUsername("power").isPresent()) {
////            userDao.save(User.builder()
////                    .username("power")
////                    .password(new BCryptPasswordEncoder().encode("power"))
////                    .authorities(ImmutableList.of(Role.POWER_USER))
////                    .accountNonLocked(true)
////                    .accountNonExpired(true)
////                    .credentialsNonExpired(true)
////                    .enabled(true)
////                    .build());
////        }
//    }

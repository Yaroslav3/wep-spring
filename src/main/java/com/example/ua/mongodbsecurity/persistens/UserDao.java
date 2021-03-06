package com.example.ua.mongodbsecurity.persistens;

import com.example.ua.mongodbsecurity.model.User;
import com.example.ua.mongodbsecurity.model.UserFieldForTable;
import com.sun.istack.internal.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class UserDao {


    @Autowired
    private MongoTemplate mongoTemplate;


    public Optional<User> findByUsername(@NotNull String username) {
        return Optional.ofNullable(mongoTemplate.findOne(
                query(where(UserFieldForTable.USER_NAME.field())
                        .is(username)), User.class));
    }

    public void save(@NotNull User user) {
        mongoTemplate.save(user);
    }

    public Optional<User> findById(@NotNull ObjectId id) {
        return Optional.ofNullable(mongoTemplate.findById(id,User.class));
    }
}


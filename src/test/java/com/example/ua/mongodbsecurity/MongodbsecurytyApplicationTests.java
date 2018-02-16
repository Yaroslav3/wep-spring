package com.example.ua.mongodbsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbsecurytyApplicationTests {

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = "password";
		String encode = encoder.encode(pass);
		System.out.println(encode);
		boolean password = encoder.matches(pass, "password");
		System.out.println(password);
	}

}

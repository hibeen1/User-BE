package com.example.springbootbackend;

import com.example.springbootbackend.model.User;
import com.example.springbootbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User();
//		user1.setUserId("kimssafy");
//		user1.setPassword("kimssafy");
//		user1.setName("kimssafy");
//		user1.setNickname("kimssafy");
//		user1.setEmail("kimssafy@ssafy.com");
//		userRepository.save(user1);
//
//		User user2 = new User();
//		user2.setUserId("hwangssafy");
//		user2.setPassword("hwangssafy");
//		user2.setName("hwangssafy");
//		user2.setNickname("hwangssafy");
//		user2.setEmail("hwangssafy@ssafy.com");
//		userRepository.save(user2);
	}
}

package com.ikubinfo.ioc;

import com.ikubinfo.ioc.currencyconverter.domain.CoinService;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.ExchangeService;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.ioc.entities.UserEntity;
import com.ikubinfo.ioc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/jpa")
public class TestJpaResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	private ExchangeRespnse exchange() {
		userRepository.addUser(createUser());
		return null;
	}
	public static UserEntity createUser() {
		UserEntity user = new UserEntity();
		user.setFirstName("doland");
		user.setLastName("balla");
		user.setEmail("doland@gmail.com");
		user.setPassword("doland");
		user.setUsername("doland123");
		user.setValid(Boolean.TRUE);
		user.setCreatedOn(LocalDateTime.now());
		return user;
	}
}

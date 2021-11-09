package com.zubentsov.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.zubentsov.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortunesService();
	}
	
	//define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
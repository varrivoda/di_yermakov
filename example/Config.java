package example;

import example.Bean;
import

public class Config{
	
	@Bean
	public static Planet mercury(){
		//..do something
		return new Planet("Mercury");
	}
	
	
	@Bean
	public static Planet venus(){
		//..do something
		return new Planet("Venus");
	}

	@Bean("sun")
	public static Sun getSun(){
		//..do something
		return new Sun(5);
	}
}
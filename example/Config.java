package example;

import example.Bean;

public class Config{
	
	@Bean
	public static Planet getPlanet1(){
		//..do something
		return new Planet("Mercury");
	}
	
	@Bean
	public static Planet getPlanet2(){
		//..do something
		return new Planet("Venus");
	}

	@Bean
	public static Sun getSun(){
		//..do something
		return new Sun(5);
	}
}
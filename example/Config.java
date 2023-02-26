package example;

import example.Bean;
import java.util.Random;

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
	@Prototype
	public static Sun getSun(){
		//random Brightness here
		Random random = new Random();
		return new Sun(random.nextInt(100));
	}
}
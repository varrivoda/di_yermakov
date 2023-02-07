package example;

import example.Bean;

public class Config{
	public static Planet planet1(){
		//do something
		// ? but why STATIC modifier?
		return new Planet("Mercury");
	}
	
	public static Planet planet2(){
		//do something
		return new Planet("Venus");
	}
	
	public static Sun sun(){
		//do something
		return new Sun(5);
	}
	
}
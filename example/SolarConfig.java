package example;

import java.util.List;

public class SolarConfig{
	@Bean
	public static SolarSystem solarSystem(Sun sun, List<Planet> planets){
		SolarSystem sSystem = new SolarSystem();
		sSystem.sun = sun;
		sSystem.planets = planets;
		return sSystem;	
	}
	
}
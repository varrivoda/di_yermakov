// In this priject wewillcreate asolar system
//but wewant only tocreate a S.S, but not a planet,sun etc..
//planets and sun wil createsomeother employee
package example;

import example.Bean;
import example.Config;
import example.Container;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
//import java.lang.IllegalAccessException;

import java.util.List;
import java.util.ArrayList;

public class Main{
	@SneakyThrows
	public static void main(String[] args) throws Throwable{	// IllegalAccessException, InvocationTargetException{

		SolarSystem solarSystem = new SolarSystem();
		
		Container container = new Container(Config.class);
		
		//List listObjects = container.getListObjects();
		
		solarSystem.sun = container.getBean("sun", Sun.class);
		solarSystem.planets.add(container.getBean("mercury", Planet.class));
		solarSystem.planets.add(container.getBean("venus", Planet.class));
		
		solarSystem.sun = container.getBean("sun", Sun.class);
		System.out.println(solarSystem);
		
		solarSystem.sun = container.getBean("sun", Sun.class);
		System.out.println(solarSystem);
		
	}
}

class Planet{
	String name;
	
	Planet(String name){
		this.name = name;
	}
	
	
	//String getName(){	return this.name;}
	
	public String toString(){
		return this.name;	
	}
}

class Sun{
	int brightness;
	
	Sun(int brightness){
		this.brightness = brightness;
	}
	public String toString(){
		return "The Sun has brightness: " + this.brightness;	
	}
}

class SolarSystem{
	Sun sun;
	List<Planet> planets = new ArrayList<>();
	
	/*
	SolarSystem (Sun sun, List<Planet> planets){
		this.sun = sun;
		this.planets = planets;
	}
	*/
	
	public String toString(){
		return sun + ", and planets are: "
				+ planets;
	}
}

/*
old main(){
	Container continer = new Container();
	container.load(Config.class);
	container.getListObjects();
	
	for (inti=0;i<listObjects.size(); i++){
		if(listObjects.get(i) instanceof Sun) sSystem.sun = (Sun) listObjects.get(i)
		else sSystem.planets.add((Planet)listObjects.get(i));
	}
}
*/

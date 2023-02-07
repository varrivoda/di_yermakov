// In this priject wewillcreate asolar system
//but wewant only tocreate a S.S, but not a planet,sun etc..
//planets and sun wil createsomeother employee
package example;

import example.Bean;
import example.Config;
import example.Container;

import java.lang.reflect.InvocationTargetException;
//import java.lang.IllegalAccessException;

import java.util.List;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) throws IllegalAccessException, 
											InvocationTargetException{
		/*
		создание объектов вручную
		Sun sun = new Sun(7);
		Planet planet1 = new Planet ("Earth");
		List<Planet> planets =  new ArrayList<>();
		planets.add(planet1);
		SolarSystem solarSystem = new SolarSystem(sun, planets);
		System.out.println(solarSystem);
		*/
		SolarSystem solarSystem = new SolarSystem();
		
		Container container = new Container();
		container.load(Config.class);
		List listObjects = container.getListObjects();
		
		for(int i=0; i<listObjects.size(); i++){
			if(listObjects.get(i) instanceof Sun){
				solarSystem.sun = (Sun)listObjects.get(i);
			}else{
				solarSystem.planets.add((Planet)listObjects.get(i));
			}
		}
		
		System.out.println(listObjects);
		
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
				+ planets.size();
	}
}
package example;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import example.Bean;

import java.lang.reflect.InvocationTargetException;
//import java.lang.IllegalAccessException;

public class Container{
	private List<Object>  listObjects = new ArrayList<>();
	
	public void load(Class clazz) throws IllegalAccessException, 
									InvocationTargetException{
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods){
			if(m.isAnnotationPresent(Bean.class)){
				listObjects.add(m.invoke(null));		//What's this?
			}
		}
	}
	
	List<Object> getListObjects(){
		return new ArrayList<>(listObjects);
	}
}
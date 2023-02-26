package example;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import example.Bean;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
//import java.lang.IllegalAccessException;

public class Container{
	private Map<String, Object> mapObjects = new HashMap<>();
	private Class clazz;
	private Map<String, Method>mapMethods = new HashMap<>();
		
	
	@SneakyThrows
	public Container(Class clazz) throws Throwable{
		this.clazz = clazz;
		refresh();
	}

	@SneakyThrows
	public void refresh() throws Throwable{//throws IllegalAccessException, InvocationTargetException{
		mapObjects.clear();
		Method[] methods = this.clazz.getDeclaredMethods();
		for(Method m:methods){
			if(m.isAnnotationPresent(Bean.class)){
				
				String key = m.getAnnotation(Bean.class).value();
				if(key.isEmpty()) 
					key = m.getName();	
				
				if(m.isAnnotationPresent(Prototype.class)){
					mapObjects.put(key, null);	///связка с getBean (если null)
					mapMethods.put(key, m);
				}else{
					mapObjects.put(key, m.invoke(null));
				}
			}

		}
	}
	
	/*public Object getBean(String key){
		if(mapObjects.get(key)!= null){
			return mapObjects.get(key);
		} else{
			return mapMethods.get(key);
		}
	}*/

	public <T> T getBean (String key, Class<T> cl) throws Throwable{
		if(mapObjects.get(key)!= null){
			return (T) mapObjects.get(key);
		} else{
			return (T) mapMethods.get(key).invoke(null);
		}
	}
	
	List<Object> getListObjects(){
		return new ArrayList<>(mapObjects.values());
	}
	
}
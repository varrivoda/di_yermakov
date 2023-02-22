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
				if(key.isEmpty()) key = m.getName();
				//^здесь мы берем имя метода,если анннотация без текста
				
				
				mapObjects.put(key, m.invoke(null));
			}
		}
	}
	
	public Object getBean(String key){
		return mapObjects.get(key);
	}

	public <T> T getBean(String key, Class<T> cl){
		return (T)mapObjects.get(key);
	}
	
	List<Object> getListObjects(){
		return new ArrayList<>(mapObjects.values());
	}
	
}
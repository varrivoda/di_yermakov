package example;

import java.util.List;
import java.util.ArrayList;

public class Container{
	private List<Object> objects = new ArrayList();
	
	public void load(Class class){
		
	}
	
	public List<Object> listObjects {
		return new ArrayList<>(objects); 
		// why do we duplicate creation of ArrayList here?
	}
}

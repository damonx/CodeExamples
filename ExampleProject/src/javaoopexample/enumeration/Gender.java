package javaoopexample.enumeration;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Gender implements Serializable {
    private final Character sex;
    private final transient String description;
    
    public Character getSex(){
    	return sex;
    }
    
    public String getDescription(){
    	return description;
    }
    
    private static final Map<Character, Gender> instancesBySex = new HashMap<Character, Gender>();
    
    private Gender (Character sex, String description){
    	this.sex = sex;
    	this.description = description;
    	instancesBySex.put(sex, this);
    }
    
    public static final Gender FEMALE = new Gender (new Character('F'), "Female");
    public static final Gender MALE = new Gender (new Character('M'), "Male");
    
    public static Collection<Gender> getAllValues(){
    	return Collections.unmodifiableCollection(instancesBySex.values());
    }
    
    public static Gender getInstance(Character sex){
    	Gender result = (Gender)instancesBySex.get(sex);
    	if (result == null){
    		throw new NoSuchElementException(sex.toString());
    	}
    	return result;
    }
    
    public String toString(){
    	return description;
    }
    
    private Object readResolve(){
    	return getInstance(sex);
    }
}

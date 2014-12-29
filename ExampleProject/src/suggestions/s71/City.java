package suggestions.s71;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class City implements Comparable<City> {

    private String code;
    private String name;
    
    
    
    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    

    public City(String code, String name) {
        this.code = code;
        this.name = name;
    }



    @Override
    public int compareTo(City o) {
       return new CompareToBuilder().append(name, o.name).toComparison();      
    }



    @Override
    public boolean equals(Object obj) {
        if (obj==null){
            return false;
        }
        if (obj==this){
            return true;
        }
        if (obj.getClass()!= getClass()){
            return false;
        }
        
        City city = (City)obj;
        return new EqualsBuilder().append(name, city.name).isEquals();
    }
    
    
   
}

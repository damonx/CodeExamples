package suggestions.s71.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

private ArrayUtils(){}
  
   public static <T> List<T> asList(T...ts){
       List<T> list = new ArrayList<T>();
       Collections.addAll(list, ts);
       return list;
   }
    
   public static void main(String[] args) {
       List<String> list = ArrayUtils.asList("A","B");
       List<Number> list3 = ArrayUtils.<Number>asList(1,2,3.1);
       List<Integer> list4 = ArrayUtils.<Integer>asList();
   }
}

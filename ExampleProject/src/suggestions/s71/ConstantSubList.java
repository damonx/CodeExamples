package suggestions.s71;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstantSubList {
    public static void main(String[] args) {
       List<String> list = new ArrayList<String>();
       list.add("a");
       list.add("b");
       list.add("c");
       list = Collections.unmodifiableList(list);
       
       List<String> subList = list.subList(0, 1);
       for (int i=0, size=subList.size();i<size; i++){
           System.out.println(subList.get(i));
       }
    }
}

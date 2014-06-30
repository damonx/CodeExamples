package concurrentExamples.chapter5.conccurentNaviablemap;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();
        Thread threads[] = new Thread[25];
        int counter = 0;
        for (char i= 'A'; i<'Z'; i++){
            Task task = new Task(map,String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }
        
        for (int i=0;i<25; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Main: Size of the map: " + map.size());
        Map.Entry<String, Contact> element;
        Contact contact;
        
        element = map.firstEntry();
        contact = element.getValue();
        System.out.println("Main: First Entry: " + contact.getName() + " " + contact.getPhone());
        
        element = map.lastEntry();
        contact = element.getValue();
        System.out.println("Main: Last Entry: " + contact.getName() + " " + contact.getPhone());
        
        System.out.println("Main: Submap from A1996 to B1002: ");
        ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
        do{
            element = submap.pollFirstEntry();
            if(element !=null){
                contact=element.getValue();
                System.out.printf("%s: %s\n",contact.getName(),contact.getPhone());
            }
        }while(element != null);
        
    }

}

package javaoopexample.collection;

import java.util.*;
public class PerformanceTester{
  private static final int TIMES=100000;

  public static abstract class Tester{
    private String operation;
    public Tester(String operation){this.operation=operation;}
    public abstract void test(List<String> list);
    public String getOperation(){return operation;}
  }

  static Tester iterateTester=new Tester("iterate"){
      public void test(List<String> list){  
       for(int i=0;i<10;i++){
          Iterator<String> it=list.iterator();
          while(it.hasNext()){
            it.next();
          }
        }
      }
  };

  static Tester getTester=new Tester("get"){
      public void test(List<String> list){ 
         for(int i=0;i<list.size();i++)
           for(int j=0;j<10;j++)
              list.get(j);
      }
  };

  static Tester insertTester=new Tester("insert"){
    public void test(List<String> list){  
      ListIterator<String> it=list.listIterator(list.size()/2);  
      for(int i=0;i<TIMES/2;i++)
        it.add("hello");
    }
  };

  static Tester removeTester=new Tester("remove"){
    public void test(List<String> list){   
      ListIterator<String> it=list.listIterator();
      while(it.hasNext()){
        it.next();
        it.remove();
      }
    }
  };

  static public void testJavaArray(List<String> list){
     Tester[] testers={iterateTester,getTester};
     test(testers,list);
  }
  static public void testList(List<String> list){
    Tester[] testers={insertTester,iterateTester,getTester,removeTester};
    test(testers,list);
  }
  static public void test(Tester[] testers,List<String> list){
    for(int i=0;i<testers.length;i++){
      System.out.print(testers[i].getOperation()+"≤Ÿ◊˜£∫");
      long t1=System.currentTimeMillis();
      testers[i].test(list);
      long t2=System.currentTimeMillis();
      System.out.print(t2-t1+" ms");
      System.out.println();
    }
  }
  public static void main(String args[]){
    List<String> list=null;

    //≤‚ ‘Java ˝◊È
    System.out.println("----≤‚ ‘Java ˝◊È----");
    String[] ss=new String[TIMES];
    Arrays.fill(ss,"hello");
    list=Arrays.asList(ss);
    testJavaArray(list);

    ss=new String[TIMES/2];
    Collection<String> col=Arrays.asList(ss);

    //≤‚ ‘Vector
    System.out.println("----≤‚ ‘Vector----");
    list=new Vector<String>();
    list.addAll(col);
    testList(list);

    //≤‚ ‘LinkedList
    System.out.println("----≤‚ ‘LinkedList----");
    list=new LinkedList<String>();
    list.addAll(col); 
    testList(list);

    //≤‚ ‘ArrayList
    System.out.println("----≤‚ ‘ArrayList----");
    list=new ArrayList<String>();
    list.addAll(col);
    testList(list);
  }
}



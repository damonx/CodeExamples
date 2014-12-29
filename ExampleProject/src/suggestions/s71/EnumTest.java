package suggestions.s71;

enum Season{
    Spring, Summer, Fall, Winter;
    public static Season getComfortableSeason(){
        return Spring;
    }
    public static boolean contains(String name){
        Season[] season = values();
        for (Season s : season){
            if (s.name().equals(name)){
                return true;
            }
        }
        return false;
    }
}

enum Role{
    
    Admin("admin", "10HOURS", "R/W"),
    User("user","1HOUR", "READONLY");
    
    private String name;
    private String time;
    private String scope;
    
    Role(String _name, String _time, String _scope){
        name = _name;
        time = _time;
        scope = _scope;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getScope() {
        return scope;
    }
    
    
}

public class EnumTest {
   public static void main(String[] args) {
       for (Season s: Season.values()){
           System.out.println(s);
           System.out.println(s.ordinal());
       }
       System.out.println("comfortable season:" + Season.getComfortableSeason());
       System.out.println("Role: Admin:" + Role.Admin.getName());
       System.out.println("Role: Admin scope: " + Role.Admin.getScope());
   }
}

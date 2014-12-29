package zenOfDesignPatterns.factory;

public class HumanFactory extends AbstractHumanFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try{
            human = (T)Class.forName(c.getName()).newInstance();
        }catch(Exception e){
            System.out.println("Errors when yielding human");
        }
        return (T)human;
    }

}

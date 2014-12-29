package suggestions.proxy.decorator;

public class FlyFeature implements Feature {

    @Override
    public void load() {
        System.out.println("Added wings...");
    }

}

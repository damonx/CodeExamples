package suggestions.proxy.decorator;

public class DigFeature implements Feature {

    @Override
    public void load() {
        System.out.println("Added digging...");
    }

}

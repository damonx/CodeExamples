package suggestions.s71.authentication;

public enum CommonIdentifier implements Identifier {
    Reader,Author,Admin;
    
    @Override
    public boolean identify() {
        return true;
    }
    
}

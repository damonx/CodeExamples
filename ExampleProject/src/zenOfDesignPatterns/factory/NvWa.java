package zenOfDesignPatterns.factory;

public class NvWa {

    public static void main(String[] args) {
       AbstractHumanFactory YinYangLu = new HumanFactory();
       
       System.out.println("Creating white human");
       Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
       whiteHuman.getColor();
       whiteHuman.talk();
       
       System.out.println("Creating black human");
       Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
       blackHuman.getColor();
       blackHuman.talk();
       
       System.out.println("Creating yellow human");
       Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
       yellowHuman.getColor();
       yellowHuman.talk();
       
    }

}

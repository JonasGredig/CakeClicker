package ch.jonasgredig.cakeclicker;

public class Starter {

    public static void main(String[] args) {
        try {
            new CakeClickerMainFrame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

package lab1.src.domain.models;

public class Samsung implements IMobile {

    @Override
    public void cost() {
       System.out.println("Samsung Cost starts from 5000");
    }

    @Override
    public void pictureCapacity() {
       System.out.println("Samsung camera capacity starts from 10 MP");
    }

    @Override
    public void batteryPower() {
       System.out.println("Samsung battery power starts from 3000 MAh");
    }
}
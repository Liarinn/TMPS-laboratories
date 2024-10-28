package lab1.src.domain.models;

public class Iphone implements IMobile {

    @Override
    public void cost() {
       System.out.println("Iphone cost starts from 15000");
    }

    @Override 
    public void pictureCapacity() {
       System.out.println("Iphone camera capacity starts from 10 MP");
    }

    @Override
    public void batteryPower() {
       System.out.println("Iphone battery power starts from 3000 MAh");
    }
}
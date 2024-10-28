package lab1.src.client;

import lab1.src.domain.factory.SimpleMobileFactory;
import lab1.src.domain.models.Iphone;
import lab1.src.domain.models.Samsung;

public class FactoryTest {

    public static void main(String[] args) {
       SimpleMobileFactory factory= new SimpleMobileFactory();

       Iphone len = (Iphone)factory.createMobile("len");
       len.batteryPower();

       Samsung sam= (Samsung)factory.createMobile("sam");
       sam.cost();
    }
}
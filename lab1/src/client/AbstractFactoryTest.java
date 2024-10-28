package lab1.src.client;

import lab1.src.domain.factory.AdvancedMobileFactory;
import lab1.src.domain.factory.IphoneMobileFactory;
import lab1.src.domain.models.Iphone;

public class AbstractFactoryTest {

    public static void main(String[] args) {
       AdvancedMobileFactory factory = new AdvancedMobileFactory();
       IphoneMobileFactory lmf = (IphoneMobileFactory)factory.createMobile("lenf");
       Iphone ln = (Iphone)lmf.createIphoneMobile();
       ln.pictureCapacity();
    }
}

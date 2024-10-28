package lab1.src.domain.factory;

import lab1.src.domain.models.IMobile;
import lab1.src.domain.models.Iphone;
import lab1.src.domain.models.Samsung;

public class SimpleMobileFactory {

    public SimpleMobileFactory() {}

    public IMobile createMobile(String type) {
        IMobile mob = null;
        if ("len".equalsIgnoreCase(type)) {
            mob = new Iphone();
            System.out.println("Iphone created");
        } else if ("sam".equalsIgnoreCase(type)) {
            mob = new Samsung();
            System.out.println("Samsung created");
        }
        return mob;
    }
}


package lab1.src.domain.factory;

import lab1.src.domain.models.Samsung;

public class SamsungMobileFactory extends AdvancedMobileFactory {

    Samsung createSamsungMobile(){
       return new Samsung();
    }
}
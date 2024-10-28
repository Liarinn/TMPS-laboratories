package lab1.src.domain.factory;

import lab1.src.domain.models.Iphone;

public class IphoneMobileFactory extends AdvancedMobileFactory {

    public Iphone createIphoneMobile(){
      return new Iphone();
    }
}
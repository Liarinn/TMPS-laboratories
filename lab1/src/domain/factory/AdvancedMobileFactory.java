package lab1.src.domain.factory;

public class AdvancedMobileFactory implements IMobileFactory {

    @Override  
    public IMobileFactory createMobile(String type) {

       IMobileFactory mob = null;
       if ("lenf".equalsIgnoreCase(type)){
           mob= new IphoneMobileFactory();
       } else if ("samf".equalsIgnoreCase(type)){
           mob= new SamsungMobileFactory();
       }
       return mob;
    } 
}

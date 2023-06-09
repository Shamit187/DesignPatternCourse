package Builder;

import Product.Application.DefaultApplication;
import Product.CommSystem.ECommSystem;
import Product.CommSystem.SimCard;
import Product.CommSystem.WifiModule;
import Product.Display.LCD;
import Product.Processor.RaspberryPi;
import Util.SystemU;

public class Deluxe extends SystemBuilder{
    @Override
    public SystemU buildSystem(int numberOfDisplay, ECommSystem commSystem) {
        SystemU systemU = new SystemU();
        systemU.addProduct(new DefaultApplication());
        systemU.addProduct(new RaspberryPi());
        for(int i = 0; i < numberOfDisplay; i++){
            systemU.addProduct(new LCD());
        }
        switch (commSystem){
            case WIFIMODULE:
                systemU.addProduct(new WifiModule());
                break;
            case SIMCARD:
                systemU.addProduct(new SimCard());
                break;
            default:
                break;
        }
        addToList(systemU);
        return systemU;
    }
}

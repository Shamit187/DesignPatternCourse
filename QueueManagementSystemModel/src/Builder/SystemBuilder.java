package Builder;

import Product.CommSystem.ECommSystem;
import Util.SoldSystemList;
import Util.SystemU;

public abstract class SystemBuilder {
    protected void addToList(SystemU systemU){
        SoldSystemList.addNewSystem(systemU);
    }

    abstract public SystemU buildSystem(int numberOfDisplay, ECommSystem commSystem);

    public static SystemU buildSystem(EPackage ePackage, int numberOfDisplay, ECommSystem commSystem){
        SystemBuilder systemBuilder = null;
        switch (ePackage){
            case POOR:
                systemBuilder = new Poor();
                break;
            case DELUXE:
                systemBuilder = new Deluxe();
                break;
            case OPTIMAL:
                systemBuilder = new Optimal();
                break;
            default:
                break;
        }
        return systemBuilder.buildSystem(numberOfDisplay, commSystem);
    }
}

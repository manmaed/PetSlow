package manmaed.petslow.libs.util.events;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by manmaed on 11/07/2017.
 */
public class EventRegisterHelper {

    private final EventBlockRegister eventBlockRegister;
    private final EventItemRegister eventItemRegister;
    private final EventModelRender eventModelRender;

    public EventRegisterHelper(FMLPreInitializationEvent event) {
        eventBlockRegister = new EventBlockRegister();
        eventItemRegister = new EventItemRegister();
        if(event.getSide() == Side.CLIENT) {
            eventModelRender = new EventModelRender();
        } else {
            eventModelRender = null;
        }
    }

    public EventBlockRegister getEventBlockRegister() {
        return eventBlockRegister;
    }

    public EventItemRegister getEventItemRegister() {
        return eventItemRegister;
    }

    public EventModelRender getEventModelRender() throws NullPointerException {
        if(eventModelRender == null) {
            throw  new NullPointerException();
        } else {
            return eventModelRender;
        }
    }
}

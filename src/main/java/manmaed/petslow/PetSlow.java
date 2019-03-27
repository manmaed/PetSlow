package manmaed.petslow;

import manmaed.petslow.blocks.PRBlocks;
import manmaed.petslow.entity.PSEntitys;
import manmaed.petslow.items.PSItems;
import manmaed.petslow.libs.LogHelper;
import manmaed.petslow.libs.Reference;
import manmaed.petslow.libs.SoundHandler;
import manmaed.petslow.libs.util.RegistryHelper;
import manmaed.petslow.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        certificateFingerprint = "@FINGERPRINT@"
)

public class PetSlow {

    /**
     *
     */

    @Mod.Instance(Reference.MOD_ID)
    public static PetSlow instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.PROXY_COMMON)
    public static CommonProxy proxy;
    private static RegistryHelper registryHelper;
    private static final String FINGERPRINT = "@FINGERPRINT@";
    private static boolean devenvsign = false;
    private static boolean invalsign = false;
    public static final String SLOW_UUID = "d2839efc727a426397ce3c73cdee5013";

    @Mod.EventHandler
    public void onInvalidFingerprint(FMLFingerprintViolationEvent event) {
        if(event.isDirectory()){
            devenvsign = true;
        }
        if(!event.isDirectory()) {
            invalsign = true;
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registryHelper = new RegistryHelper(event);
        PRBlocks.load();
        PSItems.load();
        PSEntitys.load();
        proxy.renderentitys();
        SoundHandler.registerSounds();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        //Do Something?
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (devenvsign) {
            LogHelper.info(Reference.NO_FINGERPRINT_MESSAGE);
        }
        if (invalsign) {
            LogHelper.warn(Reference.INVALID_FINGERPRINT_MESSAGE);
        }
        proxy.renderlayers();
    }
    public static RegistryHelper getRegistryHelper() {
        return registryHelper;
    }
}
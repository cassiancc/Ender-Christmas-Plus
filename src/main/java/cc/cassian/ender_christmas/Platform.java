package cc.cassian.ender_christmas;

//? fabric {
/*import cc.cassian.ender_christmas.fabric.FabricPlatformImpl;
*///?}
//? neoforge {
import cc.cassian.ender_christmas.neoforge.NeoForgePlatformImpl;
//?}
import java.nio.file.Path;

public interface Platform {

    //? fabric {
    /*Platform INSTANCE = new FabricPlatformImpl();
    *///?}
    //? neoforge {
    Platform INSTANCE = new NeoForgePlatformImpl();
    //?}


    boolean isModLoaded(String modid);
    String loader();
    Path getConfigDir();
    boolean isDevelopment();

}

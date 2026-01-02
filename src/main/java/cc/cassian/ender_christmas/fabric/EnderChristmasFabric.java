package cc.cassian.ender_christmas.fabric;

//? fabric {

/*import cc.cassian.ender_christmas.EnderChristmas;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import static cc.cassian.ender_christmas.EnderChristmas.MOD_ID;

public final class EnderChristmasFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        EnderChristmas.init();
        ResourceLoader.registerBuiltinPack(Identifier.fromNamespaceAndPath(MOD_ID, "ender_christmas_everyday"), FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), Component.literal("Ender Christmas Everyday"), PackActivationType.NORMAL);
    }

}
*///?}
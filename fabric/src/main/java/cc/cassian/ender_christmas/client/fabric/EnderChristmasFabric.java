package cc.cassian.ender_christmas.client.fabric;

import cc.cassian.ender_christmas.EnderChristmas;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static cc.cassian.ender_christmas.EnderChristmas.MOD_ID;

public final class EnderChristmasFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        EnderChristmas.init();
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, "ender_christmas_everyday"), FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), Text.literal("Ender Christmas Everyday"), ResourcePackActivationType.NORMAL);
    }

}

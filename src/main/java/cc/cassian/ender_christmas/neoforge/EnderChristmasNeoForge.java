package cc.cassian.ender_christmas.neoforge;

//? neoforge {
/*import cc.cassian.ender_christmas.EnderChristmas;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod(value = EnderChristmas.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber
public class EnderChristmasNeoForge {

    public EnderChristmasNeoForge() {
        EnderChristmas.init();
    }

    @SubscribeEvent
    public static void addEnderChristmasEveryday(AddPackFindersEvent event) {
        event.addPackFinders(Identifier.fromNamespaceAndPath(EnderChristmas.MOD_ID, "resourcepacks/ender_christmas_everyday"), PackType.CLIENT_RESOURCES, Component.literal("ender_christmas/ender_christmas_everyday"), PackSource.BUILT_IN, false, Pack.Position.TOP);
    }

}
*///?}
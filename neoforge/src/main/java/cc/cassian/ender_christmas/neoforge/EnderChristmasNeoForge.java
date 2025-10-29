package cc.cassian.ender_christmas.neoforge;

import cc.cassian.ender_christmas.EnderChristmas;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import static cc.cassian.ender_christmas.EnderChristmas.MOD_ID;


@Mod(MOD_ID)
public final class EnderChristmasNeoForge {
    public EnderChristmasNeoForge(IEventBus eventBus, ModContainer container) {
        // Run our common setup.
        EnderChristmas.init();
        eventBus.addListener(EnderChristmasNeoForge::addEnderChristmasEveryday);
    }

    private static void addEnderChristmasEveryday(AddPackFindersEvent event) {
        event.addPackFinders(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resourcepacks/ender_christmas_everyday"), PackType.CLIENT_RESOURCES, Component.literal("ender_christmas/ender_christmas_everyday"), PackSource.BUILT_IN, false, Pack.Position.TOP);
    }

}

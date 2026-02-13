package cc.cassian.ender_christmas;



import cc.cassian.ender_christmas.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnderChristmas implements ClientModInitializer
{
	static public final String MOD_ID = "ender_christmas_plus";
	static public final String MOD_NAME = "Ender Christmas Plus";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	public static final ModConfig CONFIG = ModConfig.createToml(FabricLoader.getInstance().getConfigDir(), "", MOD_ID, ModConfig.class);

	public static void init() {
		LOGGER.info("Successfully initialized Ender Christmas Plus. Have a very merry Christmas (everyday)!");
	}

	@Override
	public void onInitializeClient() {
		init();
	}
}

package cc.cassian.ender_christmas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnderChristmas
{
    static public final String MOD_ID = "ender_christmas_plus";
    static public final String MOD_NAME = "Ender Christmas Plus";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static void init() {
        LOGGER.info("Successfully initialized Ender Christmas Plus. Have a very merry Christmas (everyday)!");
    }
}

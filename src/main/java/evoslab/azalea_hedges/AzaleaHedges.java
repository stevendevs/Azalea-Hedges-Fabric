package evoslab.azalea_hedges;

import evoslab.azalea_hedges.data.HedgesDataGen;
import evoslab.azalea_hedges.init.AzaleaHedgeBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AzaleaHedges implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "azalea_hedges";
    public static final String MOD_NAME = "Azalea Hedges";

    @Override
    public void onInitialize() {
        AzaleaHedgeBlocks.init();
        HedgesDataGen.init();

        log(Level.INFO, "Azalealizing");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }
    public static Identifier id(String id){
        return new Identifier(MODID, id);
    }
}
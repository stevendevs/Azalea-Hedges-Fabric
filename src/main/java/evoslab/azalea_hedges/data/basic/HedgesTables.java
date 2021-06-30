package evoslab.azalea_hedges.data.basic;

import evoslab.azalea_hedges.AzaleaHedges;
import evoslab.azalea_hedges.data.HedgesDataGen;
import evoslab.azalea_hedges.init.AzaleaHedgeBlocks;
import me.shedaniel.cloth.api.datagen.v1.LootTableData;
import org.apache.logging.log4j.Level;

public class HedgesTables {
    public static void init(LootTableData tables) {
        try {
            tables.registerBlockDropSelf(AzaleaHedgeBlocks.AZALEA_HEDGE);
            tables.registerBlockDropSelf(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE);

            HedgesDataGen.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            AzaleaHedges.log(Level.INFO, "HedgesTables Failed!");
            System.exit(1);
        }
        AzaleaHedges.log(Level.INFO, "HedgesTables Loaded!");
    }
}
package evoslab.azalea_hedges.data.basic;

import evoslab.azalea_hedges.AzaleaHedges;
import evoslab.azalea_hedges.data.HedgesDataGen;
import evoslab.azalea_hedges.init.AzaleaHedgeBlocks;
import me.shedaniel.cloth.api.datagen.v1.ModelStateData;
import net.minecraft.data.client.model.TexturedModel;
import org.apache.logging.log4j.Level;

public class HedgesStates {
    public static void init(ModelStateData states) {
        try {
            states.addSingletonBlock(AzaleaHedgeBlocks.AZALEA_HEDGE, TexturedModel.CUBE_COLUMN);
            states.addSingletonBlock(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE, TexturedModel.CUBE_COLUMN);

            states.addSimpleBlockItemModel(AzaleaHedgeBlocks.AZALEA_HEDGE);
            states.addSimpleBlockItemModel(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE);

            HedgesDataGen.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            AzaleaHedges.log(Level.INFO, "HedgesStates Failed!");
            System.exit(1);
        }
        AzaleaHedges.log(Level.INFO, "HedgesStates Loaded!");
    }
}
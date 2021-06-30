package evoslab.azalea_hedges.data.basic;

import evoslab.azalea_hedges.AzaleaHedges;
import evoslab.azalea_hedges.data.HedgesDataGen;
import evoslab.azalea_hedges.init.AzaleaHedgeBlocks;
import me.shedaniel.cloth.api.datagen.v1.RecipeData;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import org.apache.logging.log4j.Level;

public class HedgesRecipes {
    public static void init(RecipeData recipes) {
        try {
            ShapedRecipeJsonFactory.create(AzaleaHedgeBlocks.AZALEA_HEDGE, 4)
                    .pattern("##")
                    .pattern("##")
                    .input('#', Blocks.AZALEA)
                    .criterion("has_azalea", InventoryChangedCriterion.Conditions.items(Blocks.AZALEA))
                    .offerTo(recipes);
            ShapedRecipeJsonFactory.create(AzaleaHedgeBlocks.FLOWERING_AZALEA_HEDGE, 4)
                    .pattern("##")
                    .pattern("##")
                    .input('#', Blocks.FLOWERING_AZALEA)
                    .criterion("has_flowering_azalea", InventoryChangedCriterion.Conditions.items(Blocks.FLOWERING_AZALEA))
                    .offerTo(recipes);

            HedgesDataGen.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            AzaleaHedges.log(Level.INFO, "HedgesStates Failed!");
            System.exit(1);
        }
        AzaleaHedges.log(Level.INFO, "HedgesStates Loaded!");
    }
}

package evoslab.azalea_hedges.data;

import evoslab.azalea_hedges.AzaleaHedges;
import evoslab.azalea_hedges.data.basic.HedgesRecipes;
import evoslab.azalea_hedges.data.basic.HedgesStates;
import evoslab.azalea_hedges.data.basic.HedgesTables;
import me.shedaniel.cloth.api.datagen.v1.DataGeneratorHandler;
import me.shedaniel.cloth.api.datagen.v1.LootTableData;
import me.shedaniel.cloth.api.datagen.v1.ModelStateData;
import me.shedaniel.cloth.api.datagen.v1.RecipeData;
import org.apache.logging.log4j.Level;

import java.nio.file.Paths;

public class HedgesDataGen {
    public static final DataGeneratorHandler handler = DataGeneratorHandler.create(Paths.get("../src/generated/resources"));

    public static void init() {
        ModelStateData states = handler.getModelStates();
        LootTableData tables = handler.getLootTables();
        RecipeData recipes = handler.getRecipes();

        HedgesStates.init(states);
        HedgesTables.init(tables);
        HedgesRecipes.init(recipes);

        AzaleaHedges.log(Level.INFO, "HedgesDataGen Loaded!");
    }
}
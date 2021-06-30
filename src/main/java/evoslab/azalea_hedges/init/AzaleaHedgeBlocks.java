package evoslab.azalea_hedges.init;

import evoslab.azalea_hedges.AzaleaHedges;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;

import java.util.LinkedHashMap;
import java.util.Map;

public class AzaleaHedgeBlocks {
    public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();

    public static Block AZALEA_HEDGE = registerBlock("azalea_hedge", new PillarBlock(FabricBlockSettings.copyOf(Blocks.AZALEA)));
    public static Block FLOWERING_AZALEA_HEDGE = registerBlock("flowering_azalea_hedge", new PillarBlock(FabricBlockSettings.copyOf(Blocks.FLOWERING_AZALEA)));

    public static void init(){
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }

        AzaleaHedges.log(Level.INFO, "Hedges Loaded!");
    }

    private static Block registerBlock(String id, Block block) {
        BLOCKS.put(AzaleaHedges.id(id), block);
        ITEMS.put(AzaleaHedges.id(id), new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)));
        return block;
    }
}
package com.memedream.unhingedharvest.init;

import com.memedream.unhingedharvest.UnhingedHarvest;
import com.memedream.unhingedharvest.init.blocks.CornCropBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UHBlocks {
    //TODO: Remember that all seeds are actually blocks
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UnhingedHarvest.MOD_ID);

    public static final DeferredBlock<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> MELON_PULP = registerBlock("melon_pulp",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON)));
    public static final DeferredBlock<Block> MELON_RIND = registerBlock("melon_rind",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON)));
    public static final DeferredBlock<Block> DARK_MELON_RIND = registerBlock("melon_rind",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON)));
    public static final DeferredBlock<Block> PALE_MELON_RIND = registerBlock("melon_rind",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        UHItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

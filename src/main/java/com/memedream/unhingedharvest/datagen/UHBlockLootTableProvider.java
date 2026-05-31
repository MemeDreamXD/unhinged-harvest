package com.memedream.unhingedharvest.datagen;

import com.memedream.unhingedharvest.init.UHBlocks;
import com.memedream.unhingedharvest.init.UHItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class UHBlockLootTableProvider extends BlockLootSubProvider {
    protected UHBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // Grab Enchantments for fortune bonuses
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        //Need one of these for every crop that would have multiple drops, such as tubers but not blocks that drop a flat amount of items. Maybe a better written helper make this nicer? Will invest in later.
        LootItemCondition.Builder lootitemcondition$builder0 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(UHBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));

        //Standard Formula for the vanilla loot table of carrot blocks
        this.add(UHBlocks.CORN_CROP.get(), this.applyExplosionDecay(UHBlocks.CORN_CROP.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(UHBlocks.CORN_CROP.get())))
                .withPool(LootPool.lootPool().when(lootitemcondition$builder0).add(LootItem.lootTableItem(UHItems.CORN.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return UHBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

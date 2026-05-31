package com.memedream.unhingedharvest.init;

import com.memedream.unhingedharvest.UnhingedHarvest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class UHTags {
    public static class Blocks {
        public static final TagKey<Block> PRODUCE_BLOCK = createTag("produce_block");
        public static final TagKey<Block> ROTTEN_PRODUCE_BLOCK = createTag("rotten_produce_block");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UnhingedHarvest.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> TIER_ONE_CROP = createTag("tier_one_crop");
        public static final TagKey<Item> TIER_TWO_CROP = createTag("tier_two_crop");
        public static final TagKey<Item> TIER_THREE_CROP = createTag("tier_three_crop");
        public static final TagKey<Item> TIER_FOUR_CROP = createTag("tier_four_crop");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UnhingedHarvest.MOD_ID, name));
        }
    }
}

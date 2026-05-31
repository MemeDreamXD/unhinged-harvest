package com.memedream.unhingedharvest.datagen;

import com.memedream.unhingedharvest.UnhingedHarvest;
import com.memedream.unhingedharvest.init.UHItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class UHItemModelProvider extends ItemModelProvider {
    public UHItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnhingedHarvest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(UHItems.CORN.get());
        basicItem(UHItems.CORN_SEEDS.get());
    }
}

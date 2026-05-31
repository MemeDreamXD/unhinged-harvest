package com.memedream.unhingedharvest.init;

import com.memedream.unhingedharvest.UnhingedHarvest;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UHCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnhingedHarvest.MOD_ID);

    public static final Supplier<CreativeModeTab> UNHINGED_HARVEST_ITEMS_TAB = CREATIVE_MODE_TAB.register("unhinged_harvest_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(UHItems.CORN.get()))
                    .title(Component.translatable("creativetab.unhinged_harvest.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(UHBlocks.MELON_PULP);
                        output.accept(UHBlocks.MELON_RIND);
                        output.accept(UHBlocks.DARK_MELON_RIND);
                        output.accept(UHBlocks.PALE_MELON_RIND);
                        output.accept(UHItems.CORN);
                        output.accept(UHItems.CORN_SEEDS);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

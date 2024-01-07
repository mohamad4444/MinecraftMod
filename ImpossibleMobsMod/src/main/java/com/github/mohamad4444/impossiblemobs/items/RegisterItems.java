package com.github.mohamad4444.impossiblemobs.items;

import com.github.mohamad4444.impossiblemobs.ModProperties;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {
    public static void registerAllItems() {
        Item CUSTOM_ITEM = new Item(new FabricItemSettings());
        Item CUSTOM_ITEM2 =
                Registry.register(Registries.ITEM, new Identifier(ModProperties.MOD_ID, "custom_item2"),
                        new Item(new FabricItemSettings()));
        CustomItem CUSTOM_ITEM3 = new CustomItem(new FabricItemSettings());
        CustomItem CUSTOM_ITEM4 = new CustomItem(new FabricItemSettings().maxCount(16));
        ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(ModProperties.MOD_ID, "test_group"))
                .icon(() -> new ItemStack(CUSTOM_ITEM))
                .build();

        Registry.register(Registries.ITEM, new Identifier(ModProperties.MOD_ID, "custom_item"), CUSTOM_ITEM);
        Registry.register(Registries.ITEM, new Identifier(ModProperties.MOD_ID, "custom_item3"), CUSTOM_ITEM3);
        Registry.register(Registries.ITEM, new Identifier(ModProperties.MOD_ID, "custom_item4"), CUSTOM_ITEM4);

        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.OAK_DOOR, CUSTOM_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(CUSTOM_ITEM);
        });
    }
}

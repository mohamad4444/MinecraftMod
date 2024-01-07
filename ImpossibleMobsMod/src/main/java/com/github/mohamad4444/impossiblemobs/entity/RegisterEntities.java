package com.github.mohamad4444.impossiblemobs.entity;

import com.github.mohamad4444.impossiblemobs.ModProperties;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class RegisterEntities {
    public static final EntityType<DiamondZombieEntity> DIAMOND_ZOMBIE = Registry.register(
            Registries.ENTITY_TYPE, DiamondZombieEntity.ZOMBIE_MOB_ID,
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DiamondZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build()
    );
    public static void RegisterDiamondZombie() {

        FabricDefaultAttributeRegistry.register(DIAMOND_ZOMBIE, DiamondZombieEntity.createZombieAttributes());
        SpawnRestriction.register(DIAMOND_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        Item item = new SpawnEggItem(DIAMOND_ZOMBIE, -1, -1, new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(ModProperties.MOD_ID, "dimaond_zombie_spawn_egg"),
                item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.OAK_DOOR, item);
        });
    }

}

package com.github.mohamad4444.impossiblemobs;

import com.github.mohamad4444.impossiblemobs.entity.DiamondZombieEntity;
import net.fabricmc.api.ModInitializer;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImpossibleMobs implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("impossiblemobs");
	public static final String MOD_ID = "impossiblemobs";
	public static final EntityType<DiamondZombieEntity> DIAMOND_ZOMBIE = Registry.register(
			Registries.ENTITY_TYPE, DiamondZombieEntity.ZOMBIE_MOB_ID,
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DiamondZombieEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95f))
					.build()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		// Register ScaryZombieEntity
		FabricDefaultAttributeRegistry.register(DIAMOND_ZOMBIE, DiamondZombieEntity.createZombieAttributes());
		// Register spawn conditions
		SpawnRestriction.register(DIAMOND_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		// Register spawn egg
		Item item=new SpawnEggItem(DIAMOND_ZOMBIE, -1, -1, new FabricItemSettings());
		Registry.register(Registries.ITEM, new Identifier("extrastuff", "dimaond_zombie_spawn_egg"),
				item);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.addAfter(Items.OAK_DOOR, item);
		});
	}
}
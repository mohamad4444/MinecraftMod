package com.example.extrastuff;

import com.example.extrastuff.entity.ZombieEntityExtra;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraStuff implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "extrastuff" ;

	public static final Logger LOGGER = LoggerFactory.getLogger("extrastuff");
	public static final EntityType<ZombieEntityExtra> EXTRA_ZOMBIE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "diamondzombie"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ZombieEntityExtra::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(EXTRA_ZOMBIE, ZombieEntityExtra.createMobAttributes());

	}
}
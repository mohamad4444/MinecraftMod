package com.example.extrastuff;

import com.example.extrastuff.entity.DiamondZombie;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.data.server.EntityLootTableGenerator;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraStuff implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "extrastuff";
	public static final EntityType<DiamondZombie> DIAMOND_ZOMBIE = Registry.register(
			Registry.ENTITY_TYPE, DiamondZombie.ZOMBIE_MOB_ID,
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DiamondZombie::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95f))
					.build()
	);

	@Override
	public void onInitialize() {

		// Register ScaryZombieEntity
		FabricDefaultAttributeRegistry.register(DIAMOND_ZOMBIE, DiamondZombie.createZombieAttributes());

		// Register spawn conditions
		SpawnRestriction.register(DIAMOND_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		// Register spawn egg
		Registry.register(Registry.ITEM, new Identifier("extrastuff", "dimaond_zombie_spawn_egg"),
				new SpawnEggItem(DIAMOND_ZOMBIE, -1, -1, new FabricItemSettings().group(ItemGroup.MISC)));

	}
}
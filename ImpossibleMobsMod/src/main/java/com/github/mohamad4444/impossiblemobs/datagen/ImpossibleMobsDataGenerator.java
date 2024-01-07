package com.github.mohamad4444.impossiblemobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;

import javax.swing.text.html.parser.Entity;

public class ImpossibleMobsDataGenerator implements DataGeneratorEntrypoint {
	private static class MyBlockLootTables extends FabricBlockLootTableProvider {
		public MyBlockLootTables(FabricDataOutput dataOutput) {
			super(dataOutput);
		}

		@Override
		public void generate() {
			// ...
		}
	}


// ...


	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		// ...
		FabricDataGenerator.Pack myPack = fabricDataGenerator.createPack();
		myPack.addProvider(MyBlockLootTables::new);
//		fabricDataGenerator.addProvider(MyBlockLootTables::new);
		// ...
	}
}

package com.github.mohamad4444.impossiblemobs.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.SpawnDensityCapper;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;
@Mixin(targets = "net.minecraft.world.SpawnDensityCapper$DensityCap")
public class IncreaseDensityMixin {
	@Shadow private final Object2IntMap<SpawnGroup> spawnGroupsToDensity = new Object2IntOpenHashMap<>(SpawnGroup.values().length);
	@Inject(method = "increaseDensity", at = @At("HEAD"),cancellable = true)
	private void injectMethod(SpawnGroup spawnGroup, CallbackInfo ci) {
		 this.spawnGroupsToDensity.computeInt(spawnGroup, (group, density) -> density == null ? 1 : density );
		 ci.cancel();
	}

}
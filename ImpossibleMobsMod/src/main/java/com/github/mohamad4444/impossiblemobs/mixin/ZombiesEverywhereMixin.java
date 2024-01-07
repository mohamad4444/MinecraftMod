package com.github.mohamad4444.impossiblemobs.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.Builder.class)
public class ZombiesEverywhereMixin {
	@Inject(method = "create(Lnet/minecraft/entity/EntityType$EntityFactory;Lnet/minecraft/entity/SpawnGroup;)Lnet/minecraft/entity/EntityType$Builder;", at = @At("TAIL"),cancellable = true)
	private static <T extends Entity> void injectMethod(EntityType.EntityFactory<T> factory, SpawnGroup spawnGroup, CallbackInfoReturnable<EntityType.Builder<T>> cir) {
		EntityType.EntityFactory<ZombieEntity> zombieFactory = ZombieEntity::new;
		if (factory.getClass().equals(zombieFactory.getClass())) {
			System.out.println("******************************True");
			spawnGroup=(SpawnGroup)CustomSpawnGroup.ULTRA_MONSTER;
		}
	}
}
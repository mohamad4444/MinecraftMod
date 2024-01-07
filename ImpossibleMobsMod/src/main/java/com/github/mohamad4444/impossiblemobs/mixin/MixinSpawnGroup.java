package com.github.mohamad4444.impossiblemobs.mixin;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


import net.minecraft.entity.SpawnGroup;

@Mixin(SpawnGroup.class)
public class MixinSpawnGroup {
    @Unique private static final Map<String, CustomSpawnGroup> CUSTOM_SPAWN_GROUPS;
    
    @Shadow @Final private String name;
    
    @Inject(method = "getCapacity", at = @At("HEAD"), cancellable = true)
    private void injectGetCapacity(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
            
        info.setReturnValue(spawnGroup.getCapacity());
    }
    
    @Inject(method = "isPeaceful", at = @At("HEAD"), cancellable = true)
    private void injectIsPeaceful(CallbackInfoReturnable<Boolean> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.isPeaceful());
    }
    
    @Inject(method = "isRare", at = @At("HEAD"), cancellable = true)
    private void injectIsRare(CallbackInfoReturnable<Boolean> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.isRare());
    }
    
    @Inject(method = "getImmediateDespawnRange", at = @At("HEAD"), cancellable = true)
    private void injectGetImmediateDespawnRange(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.getImmediateDespawnRange());
    }
    
    @Inject(method = "getDespawnStartRange", at = @At("HEAD"), cancellable = true)
    private void injectGetDespawnStartRange(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.getDespawnStartRange());
    }
    
    @Unique
    static CustomSpawnGroup getCustomSpawnGroup(String name) {
        return CUSTOM_SPAWN_GROUPS.get(name);
    }
    
    static {
        CUSTOM_SPAWN_GROUPS = new HashMap<>();
        
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.MONSTER.getName(), CustomSpawnGroup.MONSTER);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.CREATURE.getName(), CustomSpawnGroup.CREATURE);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.AMBIENT.getName(), CustomSpawnGroup.AMBIENT);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.AXOLOTLS.getName(), CustomSpawnGroup.AXOLOTLS);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.WATER_CREATURE.getName(), CustomSpawnGroup.WATER_CREATURE);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.WATER_AMBIENT.getName(), CustomSpawnGroup.WATER_AMBIENT);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.UNDERGROUND_WATER_CREATURE.getName(), CustomSpawnGroup.UNDERGROUND_WATER_CREATURE);
        CUSTOM_SPAWN_GROUPS.put(CustomSpawnGroup.ULTRA_MONSTER.getName(),CustomSpawnGroup.ULTRA_MONSTER);
    }
}

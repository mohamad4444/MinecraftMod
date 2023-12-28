package com.example.extrazombie.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

/*
 * Our Cube Entity extends MobEntityWithAi, which extends MobEntity, which extends LivingEntity.
 *
 * LivingEntity has health and can deal damage.
 * MobEntity has movement controls and AI capabilities.
 * MobEntityWithAi has pathfinding favor and slightly tweaked leash behavior.
 */
public class ZombieEntityExtra extends ZombieEntity {

    public ZombieEntityExtra(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }
}

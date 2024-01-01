package com.github.mohamad4444.impossiblemobs.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class DiamondZombieEntity extends ZombieEntity {
    public static final Identifier ZOMBIE_MOB_ID = new Identifier("extrastuff", "diamondzombie");


    public DiamondZombieEntity(EntityType<? extends DiamondZombieEntity> entityType, World world) {
        super(entityType, world);
    }


}

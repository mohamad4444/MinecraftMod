package com.github.mohamad4444.impossiblemobs.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
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
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class DiamondZombieEntity extends ZombieEntity {
    public static final Identifier ZOMBIE_MOB_ID = new Identifier("extrastuff", "diamondzombie");


    public DiamondZombieEntity(EntityType<? extends DiamondZombieEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);

        // Check if the damage source is enough to drop loot (e.g., player killed the entity)
        if (causedByPlayer) {
            // Drop an item (example: dropping an apple)
            ItemStack itemStack = new ItemStack(Items.DIAMOND,40); // Change this to the item you want to drop
            spawnItemEntity(itemStack);
        }
    }
    private void spawnItemEntity(ItemStack itemStack) {
        if (!this.world.isClient) {
            ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), itemStack);
            this.world.spawnEntity(itemEntity);
        }
    }
}

package com.github.mohamad4444.impossiblemobs.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;

public class DiamondZombieModel <T extends ZombieEntity>
        extends ZombieEntityModel<T> {

    public DiamondZombieModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public boolean isAttacking(T zombieEntity) {
        return ((MobEntity)zombieEntity).isAttacking();
    }

    public static TexturedModelData getTexturedModelData() {
        TexturedModelData texturedModelData = TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE, 0.0f), 64, 64);
        return texturedModelData;
    }
}

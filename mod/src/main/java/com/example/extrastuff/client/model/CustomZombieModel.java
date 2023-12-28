package com.example.extrastuff.client.model;

import com.example.extrastuff.entity.ZombieEntityExtra;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.mob.ZombieEntity;

public class CustomZombieModel extends ZombieEntityModel<ZombieEntityExtra> {
    private static final Dilation HAT_DILATION = new Dilation(0.5f);

    public CustomZombieModel(ModelPart modelPart) {
        super(modelPart);

    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(BipedEntityModel.getModelData(HAT_DILATION, 0.0f), 64, 32);
    }
}

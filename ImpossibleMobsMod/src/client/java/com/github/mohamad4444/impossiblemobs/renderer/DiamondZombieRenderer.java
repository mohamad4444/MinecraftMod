package com.github.mohamad4444.impossiblemobs.renderer;

import com.github.mohamad4444.impossiblemobs.entity.DiamondZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DiamondZombieRenderer extends ZombieEntityRenderer{
    private static final Identifier TEXTURE = new Identifier("impossiblemobs", "textures/mobs/zombie_diamond.png");

    public DiamondZombieRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected void scale(ZombieEntity zombieEntity, MatrixStack matrixStack, float f) {
        float g = 1.0625F;
        matrixStack.scale(1.0625F, 1.0625F, 1.0625F);
        super.scale(zombieEntity, matrixStack, f);
    }

    public Identifier getTexture(DiamondZombieEntity entity) {
        return TEXTURE;
    }
    @Override
    public Identifier getTexture(ZombieEntity entity) {
        return TEXTURE;
    }
}


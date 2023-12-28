package com.example.extrazombie.client.renderer;

import com.example.extrazombie.ExtraZombieClient;
import com.example.extrazombie.client.model.ZombieEntityExtraModel;
import com.example.extrazombie.entity.ZombieEntityExtra;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class ZombieEntityExtraRenderer extends MobEntityRenderer<ZombieEntityExtra, ZombieEntityExtraModel> {

    public ZombieEntityExtraRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieEntityExtraModel(context.getPart(ExtraZombieClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ZombieEntityExtra entity) {
        return new Identifier("entitytesting", "textures/entity/cube/cube.png");

    }


}
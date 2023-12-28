package com.example.extrastuff.client.renderer;

import com.example.extrastuff.ExtraStuffClient;
import com.example.extrastuff.client.model.CustomZombieModel;
import com.example.extrastuff.entity.ZombieEntityExtra;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class ZombieEntityExtraRenderer extends MobEntityRenderer<ZombieEntityExtra, CustomZombieModel> {

    public ZombieEntityExtraRenderer(EntityRendererFactory.Context context) {
        super(context, new CustomZombieModel(context.getPart(ExtraStuffClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ZombieEntityExtra entity) {
        return new Identifier("extrazombie", "textures/entity/zombie/zombie_diamond");

    }


}
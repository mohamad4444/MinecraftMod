package com.example.extrastuff;

import com.example.extrastuff.model.DiamondZombieModel;
import com.example.extrastuff.renderer.DiamondZombieRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExtraStuffClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ExtraStuff.DIAMOND_ZOMBIE, DiamondZombieRenderer::new);
    }
}

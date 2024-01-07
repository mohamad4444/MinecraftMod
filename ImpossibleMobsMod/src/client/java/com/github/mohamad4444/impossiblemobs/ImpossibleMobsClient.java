package com.github.mohamad4444.impossiblemobs;

import com.github.mohamad4444.impossiblemobs.entity.RegisterEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.github.mohamad4444.impossiblemobs.renderer.DiamondZombieRenderer;
public class ImpossibleMobsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(RegisterEntities.DIAMOND_ZOMBIE, DiamondZombieRenderer::new);	}
}
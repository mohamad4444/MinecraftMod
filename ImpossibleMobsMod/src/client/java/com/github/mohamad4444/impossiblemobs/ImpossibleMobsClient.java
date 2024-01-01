package com.github.mohamad4444.impossiblemobs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.github.mohamad4444.impossiblemobs.renderer.DiamondZombieRenderer;
public class ImpossibleMobsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(ImpossibleMobs.DIAMOND_ZOMBIE, DiamondZombieRenderer::new);	}
}
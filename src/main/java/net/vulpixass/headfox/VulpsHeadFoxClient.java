package net.vulpixass.headfox;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.EntityType;
import net.vulpixass.headfox.client.HeadFoxModelLayers;
import net.vulpixass.headfox.client.model.fox_baby;
import net.vulpixass.headfox.client.render.FoxHatFeatureRenderer;

public class VulpsHeadFoxClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(HeadFoxModelLayers.FOX_LAYER, fox_baby::getTexturedModelData );
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, registrationHelper, ctx) -> {
            if (entityType == EntityType.PLAYER && renderer instanceof PlayerEntityRenderer playerRenderer) {
                registrationHelper.register(new FoxHatFeatureRenderer(playerRenderer));
            }
        });
    }
}

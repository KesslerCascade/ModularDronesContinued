package rearth.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.MultiBufferSource;
import rearth.DronesClient;
import rearth.client.particles.IonTrailParticleProvider;
import rearth.client.renderers.DroneRenderer;
import rearth.init.ParticleContent;

public final class DronesModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DronesClient.init();
        LevelRenderEvents.AFTER_TRANSLUCENT_FEATURES.register(DronesModFabricClient::renderWorld);
        ParticleFactoryRegistry.getInstance().register(ParticleContent.ION_TRAIL.get(), IonTrailParticleProvider::new);
    }

    private static void renderWorld(LevelRenderContext context) {

        var matrices = context.poseStack();
        var camera = context.gameRenderer().getMainCamera();
        var vertexConsumers = context.bufferSource();

        DroneRenderer.doRender(matrices, camera, vertexConsumers);

    }


}

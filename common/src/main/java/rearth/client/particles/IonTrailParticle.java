package rearth.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.LightTexture;

public class IonTrailParticle extends SingleQuadParticle {

    protected IonTrailParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, SpriteSet sprites) {
        super(level, x, y, z, xd, yd, zd, sprites.first());
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.hasPhysics = false;
        this.gravity = 0f;
        this.friction = 1f;
        this.lifetime = 20 + this.random.nextInt(15);
        this.quadSize = 0.05f * (this.random.nextFloat() * 0.5f + 0.5f);
        this.setColor(0.6f, 0.85f, 1f);
        this.alpha = 0.8f;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha = 0.8f * Math.max(0f, 1f - (float) this.age / (float) this.lifetime);
    }

    @Override
    protected int getLightColor(float partialTick) {
        return LightTexture.FULL_BRIGHT;
    }

    @Override
    protected SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

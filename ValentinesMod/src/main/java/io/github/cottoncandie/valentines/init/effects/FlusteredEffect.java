package io.github.cottoncandie.valentines.init.effects;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;


public class FlusteredEffect extends MobEffect {
    public FlusteredEffect(MobEffectCategory mobEffectCategory, int colour) {
        super(mobEffectCategory, colour);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if(entity instanceof Player player) {
            Level level = player.level();

            if(!level.isClientSide) return;

            for(int i = 0; i < 1 + amplifier; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 1.5;
                double offsetY = (level.random.nextDouble() - 0) * 1.5;
                double offsetZ = (level.random.nextDouble() - 0.5) * 1.5;

                level.addParticle(ParticleTypes.HEART,
                        player.getX() + offsetX,
                        player.getY() + offsetY,
                        player.getZ() + offsetZ,
                        0, 0, 0
                );
            }
        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}

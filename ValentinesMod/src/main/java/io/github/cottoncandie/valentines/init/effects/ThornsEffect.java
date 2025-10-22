package io.github.cottoncandie.valentines.init.effects;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

public class ThornsEffect extends MobEffect {

    public ThornsEffect(MobEffectCategory mobCategory, int colour) {
        super(mobCategory, colour);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            player.getCombatTracker(); // Keeps track of recent damage

            // Check if the player has been hit recently
            if (player.getLastDamageSource() != null) {
                Entity attacker = player.getLastDamageSource().getEntity();

                if (attacker instanceof LivingEntity livingAttacker) {
                    UUID attackerUUID = livingAttacker.getUUID(); // Unique ID per attacker
                    long currentTime = player.level().getGameTime(); // Get world time in ticks

                    // Get the attacker's cooldown from the player's persistent data
                    CompoundTag data = player.getPersistentData();
                    long lastHitTime = data.getLong("thornsCooldown_" + attackerUUID);

                    // Apply effect only if enough time has passed (e.g., 40 ticks = 2 seconds)
                    if (currentTime - lastHitTime >= 40) {
                        float damage = 2.0F + (amplifier * 1.5F); // Scales with amplifier
                        float knockbackStrength = 1.0F + (amplifier * 0.5F);

                        // Apply thorns-like damage to the attacker
                        livingAttacker.hurt(player.damageSources().thorns(player), damage);

                        // Apply knockback
                        Vec3 knockbackDirection = livingAttacker.position().subtract(player.position()).normalize();
                        livingAttacker.setDeltaMovement(knockbackDirection.x * knockbackStrength, 0.5D, knockbackDirection.z * knockbackStrength);

                        // Set cooldown for this specific attacker
                        data.putLong("thornsCooldown_" + attackerUUID, currentTime);
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Ensures it runs every tick
    }
}

package io.github.cottoncandie.valentines.customs;

import io.github.cottoncandie.valentines.init.ItemInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class LoveWand extends Item {
    private int durability;
    public LoveWand(Properties properties, int dur) {
        super(properties);
        durability = dur;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {  // Server-side logic
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(5.0F);  // Heal player
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));  // Decrease durability
            }
        }

        return InteractionResultHolder.success(stack);
    }

    private EntityHitResult getEntityHitResult(Player player, Level world) {
        // Range is the maximum distance at which the player can pick entities
        double range = 5.0D;

        // Using the player's pick method to get an entity the player is looking at
        HitResult hitResult = player.pick(range, 1.0F, false);

        // Check if it's an entity hit result and cast it
        if (hitResult instanceof EntityHitResult entityHitResult) {
            return entityHitResult;  // Return the entity hit result if it is an entity
        }

        return null;  // Return null if no entity is hit
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide && entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
                livingEntity.heal(5.0F);  // Heal the entity
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));  // Reduce durability
            }
        }

        return true; // Prevents regular attack damage
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return durability; // Set max durability (example)
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairMaterial) {
        return repairMaterial.is(ItemInit.RING.get()); // Change to whatever material you want!
    }
}

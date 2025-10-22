package io.github.cottoncandie.valentines.customs;

import io.github.cottoncandie.valentines.init.EffectsInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RingItem extends Item {
    public RingItem(Item.Properties properties) {
        super(properties);
    }

    public static boolean isRingInInventory(Player player) {
        for(ItemStack stack: player.getInventory().items) {
            if(stack.getItem() instanceof RingItem) {
                return true;
            }
        }
        return false;
    }

    public static void applyFlusteredEffect(Player player) {
        if(!player.level().isClientSide()) {
            if(isRingInInventory(player)) {
                if(!player.hasEffect(EffectsInit.FLUSTERED.get())) {
                    player.addEffect(new MobEffectInstance(EffectsInit.FLUSTERED.get(), 200, 0, true, true));
                }
            }
        }
        else{
            player.removeEffect(EffectsInit.FLUSTERED.get());
        }
    }
}

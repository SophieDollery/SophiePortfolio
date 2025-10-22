package io.github.cottoncandie.valentines.events;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.customs.RingItem;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RingEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if(!player.level().isClientSide() && event.phase == TickEvent.Phase.END) {
            boolean hasRingPartner = hasRingPartner(player);

            if(hasRingPartner) {
                RingItem.applyFlusteredEffect(player);
            }
        }
    }

    public static boolean hasRingPartner(Player player) {
        return player.level().players().stream()
                .filter(otherPlayer -> otherPlayer != player)
                .filter(RingEffectHandler::hasRingInInventory)
                .anyMatch(otherPlayer -> isWithinDistance(player, otherPlayer, 10.0));
    }

    public static boolean hasRingInInventory(Player player) {
        return player.getInventory().items.stream().anyMatch(itemStack -> itemStack.getItem() instanceof RingItem);
    }

    private static boolean isWithinDistance(Player player1, Player player2, double maxDistance) {
        return player1.distanceToSqr(player2) <= (maxDistance*maxDistance);
    }
}

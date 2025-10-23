package io.github.cottoncandie.valentines.events;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.entity.Jitterbug;
import io.github.cottoncandie.valentines.init.EffectsInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JitterbugEffectHandler {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if(!player.level().isClientSide() && event.phase == TickEvent.Phase.END) {
            if((!player.hasEffect(EffectsInit.FLUSTERED.get()))&&isNearJitterbug(player)) {
                player.addEffect(new MobEffectInstance(EffectsInit.FLUSTERED.get(), 200, 0, true, true));
            }
        }
    }

    public static boolean isNearJitterbug(Player player) {
        return player.level().getEntitiesOfClass(Jitterbug.class, player.getBoundingBox().inflate(5.0))
                .stream()
                .anyMatch(jitterbug -> isWithinDistance(player, jitterbug, 4.0));
    }

    private static boolean isWithinDistance(Player player1, Jitterbug jitterbug, double maxDistance) {
        return player1.distanceToSqr(jitterbug) <= (maxDistance*maxDistance);
    }
}

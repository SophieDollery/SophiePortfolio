package io.github.cottoncandie.valentines.events;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.init.ItemInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorEffectsHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if(!player.level().isClientSide()&& event.phase == TickEvent.Phase.END) {
            if(isWearingFullGoldheart(player)) {
                ItemInit.GOLDHEART_CHESTPLATE.get().applyEffects(player);
            }
            if(isWearingFullHeartbreak(player)) {
                ItemInit.HEARTBREAK_CHESTPLATE.get().applyEffects(player);
            }
            if(isWearingFullOathbound(player)) {
                ItemInit.OATHBOUND_CHESTPLATE.get().applyEffects(player);
            }
            if(isWearingFullVoidheart(player)) {
                ItemInit.VOIDHEART_CHESTPLATE.get().applyEffects(player);
            }
        }
    }

    private static boolean isWearingFullGoldheart(Player player) {
        return isWearingPiece(player, EquipmentSlot.HEAD, ItemInit.GOLDHEART_HELMET.get()) &&
                isWearingPiece(player, EquipmentSlot.CHEST, ItemInit.GOLDHEART_CHESTPLATE.get()) &&
                isWearingPiece(player, EquipmentSlot.LEGS, ItemInit.GOLDHEART_LEGGINGS.get()) &&
                isWearingPiece(player, EquipmentSlot.FEET, ItemInit.GOLDHEART_BOOTS.get());
    }

    private static boolean isWearingFullHeartbreak(Player player) {
        return isWearingPiece(player, EquipmentSlot.HEAD, ItemInit.HEARTBREAK_HELMET.get()) &&
                isWearingPiece(player, EquipmentSlot.CHEST, ItemInit.HEARTBREAK_CHESTPLATE.get()) &&
                isWearingPiece(player, EquipmentSlot.LEGS, ItemInit.HEARTBREAK_LEGGINGS.get()) &&
                isWearingPiece(player, EquipmentSlot.FEET, ItemInit.HEARTBREAK_BOOTS.get());
    }

    private static boolean isWearingFullOathbound(Player player) {
        return isWearingPiece(player, EquipmentSlot.HEAD, ItemInit.OATHBOUND_HELMET.get()) &&
                isWearingPiece(player, EquipmentSlot.CHEST, ItemInit.OATHBOUND_CHESTPLATE.get()) &&
                isWearingPiece(player, EquipmentSlot.LEGS, ItemInit.OATHBOUND_LEGGINGS.get()) &&
                isWearingPiece(player, EquipmentSlot.FEET, ItemInit.OATHBOUND_BOOTS.get());
    }

    private static boolean isWearingFullVoidheart(Player player) {
        return isWearingPiece(player, EquipmentSlot.HEAD, ItemInit.VOIDHEART_HELMET.get()) &&
                isWearingPiece(player, EquipmentSlot.CHEST, ItemInit.VOIDHEART_CHESTPLATE.get()) &&
                isWearingPiece(player, EquipmentSlot.LEGS, ItemInit.VOIDHEART_LEGGINGS.get()) &&
                isWearingPiece(player, EquipmentSlot.FEET, ItemInit.VOIDHEART_BOOTS.get());
    }

    private static boolean isWearingPiece(Player player, EquipmentSlot equipmentSlot, Item item) {
        return player.getInventory().getArmor(equipmentSlot.getIndex()).getItem() == item;
    }
}

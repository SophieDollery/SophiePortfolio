package io.github.cottoncandie.valentines.customs;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static io.github.cottoncandie.valentines.events.RingEffectHandler.hasRingInInventory;
import static io.github.cottoncandie.valentines.events.RingEffectHandler.hasRingPartner;

public class CustomArmorItem extends ArmorItem {
    private final List<MobEffect> effects = new ArrayList<>();
    private final List<Integer> strengths = new ArrayList<>();

    public CustomArmorItem(ArmorMaterial armorMaterial, ArmorItem.Type type, Item.Properties properties) {
        super(armorMaterial, type, properties);
    }

    public CustomArmorItem addEffect(MobEffect effect, int strength) {
        effects.add(effect);
        strengths.add(strength);
        return this;
    }

    public void applyEffects(Player player) {
        int multiplier = 0;
        if(hasRingInInventory(player)&&hasRingPartner(player)) {
            multiplier = 1;
        }
        for(int i = 0; i < effects.size(); i++) {
            if(!player.hasEffect(effects.get(i))) {
                player.addEffect(new MobEffectInstance(effects.get(i), 200, strengths.get(i)+multiplier, false, false));
            }
        }
    }
}
package io.github.cottoncandie.valentines.customs;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.ArrayList;
import java.util.List;

public class CustomSword extends SwordItem {

    private final List<MobEffect> effects = new ArrayList<>();
    private final List<Integer> strengths = new ArrayList<>();
    private final List<Integer> durations = new ArrayList<>();

    public CustomSword(Tier tier, int damage, float attackSpeed, Item.Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }

    public CustomSword addEffect(MobEffect effect, int strength, int duration) {
        effects.add(effect);
        strengths.add(strength);
        durations.add(duration);
        return this;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.level().isClientSide) {
            for(int i = 0; i < effects.size(); i++) {
                target.addEffect(new MobEffectInstance(effects.get(i), durations.get(i), strengths.get(i)));
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}

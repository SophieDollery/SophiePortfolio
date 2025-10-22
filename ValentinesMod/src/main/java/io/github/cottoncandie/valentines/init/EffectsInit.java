package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.init.effects.FlusteredEffect;
import io.github.cottoncandie.valentines.init.effects.ThornsEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Valentines.MODID);

    public static final RegistryObject<MobEffect> FLUSTERED = EFFECTS.register("flustered",
            () -> new FlusteredEffect(MobEffectCategory.NEUTRAL, 0)
    );

    public static final RegistryObject<MobEffect> THORNS = EFFECTS.register("thorns",
            () -> new ThornsEffect(MobEffectCategory.BENEFICIAL, 0x0B6623)
    );
}
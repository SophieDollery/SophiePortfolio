package io.github.cottoncandie.valentines;

import io.github.cottoncandie.valentines.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Valentines.MODID)
public class Valentines {
    public static final String MODID = "valentines";

    public Valentines() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeTabInit.TAB_REGISTER.register(bus);
        EffectsInit.EFFECTS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }
}

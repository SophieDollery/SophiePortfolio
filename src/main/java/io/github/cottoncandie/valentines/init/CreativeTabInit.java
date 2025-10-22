package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Valentines.MODID);

    private static final List<Supplier<? extends ItemLike>> TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> TAB = TAB_REGISTER.register("valentines_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.valentines_tab"))
                    .icon(() -> new ItemStack(ItemInit.PASSIONITE.get()))
                    .displayItems((displayParams, output) -> {
                        TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
                    })
                    .build()
            );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(ItemInit.GOLDHEART_BLOCK_ITEM);
            event.accept(ItemInit.HEARTBREAK_BLOCK_ITEM);
            event.accept(ItemInit.OATHBOUND_BLOCK_ITEM);
            event.accept(ItemInit.VOIDHEART_BLOCK_ITEM);
        }
    }
}
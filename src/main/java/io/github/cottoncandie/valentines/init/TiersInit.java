package io.github.cottoncandie.valentines.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TiersInit {
    public static final ForgeTier GOLDHEART = new ForgeTier(
            3,
            1800,
            6f,
            0,
            25,
            TagInit.NEEDS_PASSIONITE_TOOL,
            () -> Ingredient.of(ItemInit.GOLDHEART_INGOT::get)
    );

    public static final ForgeTier HEARTBREAK = new ForgeTier(
            3,
            1800,
            6f,
            0,
            25,
            TagInit.NEEDS_PASSIONITE_TOOL,
            () -> Ingredient.of(ItemInit.HEARTBREAK_INGOT::get)
    );

    public static final ForgeTier OATHBOUND = new ForgeTier(
            5,
            1800,
            6f,
            0,
            25,
            TagInit.NEEDS_OBSIDIAN_ROSE_TOOL,
            () -> Ingredient.of(ItemInit.OATHBOUND_INGOT::get)
    );
    public static final ForgeTier VOIDHEART = new ForgeTier(
            5,
            1800,
            6f,
            0,
            25,
            TagInit.NEEDS_OBSIDIAN_ROSE_TOOL,
            () -> Ingredient.of(ItemInit.VOIDHEART_INGOT::get)
    );
}

package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.init.armormaterials.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial GOLDHEART = new ModArmorMaterial(
            new int[] {255, 370, 350, 305},
            new int[] {3, 7, 5, 2},
            25,
            SoundEvents.SNOW_STEP,
            () -> Ingredient.of(ItemInit.GOLDHEART_INGOT.get()),
            "goldheart",
            1f,
            0.0f
    );

    public static final ModArmorMaterial HEARTBREAK = new ModArmorMaterial(
            new int[] {255, 370, 350, 305},
            new int[] {3, 7, 5, 2},
            25,
            SoundEvents.GUARDIAN_AMBIENT,
            () -> Ingredient.of(ItemInit.HEARTBREAK_INGOT.get()),
            "heartbreak",
            0f,
            .1f
    );

    public static final ModArmorMaterial OATHBOUND = new ModArmorMaterial(
            new int[] {305, 420, 400, 355},
            new int[] {4, 9, 6, 3},
            30,
            SoundEvents.CAT_PURREOW,
            () -> Ingredient.of(ItemInit.OATHBOUND_INGOT.get()),
            "oathbound",
            3f,
            0.0f
    );

    public static final ModArmorMaterial VOIDHEART = new ModArmorMaterial(
            new int[] {305, 420, 400, 355},
            new int[] {4, 9, 6, 3},
            30,
            SoundEvents.AMBIENT_CAVE.get(),
            () -> Ingredient.of(ItemInit.VOIDHEART_INGOT.get()),
            "voidheart",
            1f,
            0.2f
    );
}

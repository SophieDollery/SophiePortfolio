package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.customs.CustomArmorItem;
import io.github.cottoncandie.valentines.customs.CustomSword;
import io.github.cottoncandie.valentines.customs.LoveWand;
import io.github.cottoncandie.valentines.customs.RingItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static io.github.cottoncandie.valentines.init.CreativeTabInit.addToTab;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Valentines.MODID);


    public static final RegistryObject<RingItem> RING = addToTab(ITEMS.register("ring",
            () -> new RingItem(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
            )
    ));

    public static final RegistryObject<Item> PASSIONITE = addToTab(ITEMS.register("passionite",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<BlockItem> PASSIONITE_ORE_ITEM = addToTab(ITEMS.register("passionite_ore",
            () -> new BlockItem(BlockInit.PASSIONITE_ORE.get(), new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<BlockItem> DEEPSLATE_PASSIONITE_ORE_ITEM = addToTab(ITEMS.register("deepslate_passionite_ore",
            () -> new BlockItem(BlockInit.DEEPSLATE_PASSIONITE_ORE.get(), new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<Item> OBSIDIAN_ROSE = addToTab(ITEMS.register("obsidian_rose",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<BlockItem> OBSIDIAN_ROSE_ORE_ITEM = addToTab(ITEMS.register("obsidian_rose_ore",
            () -> new BlockItem(BlockInit.OBSIDIAN_ROSE_ORE.get(), new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<Item> GOLDHEART_INGOT = addToTab(ITEMS.register("goldheart_ingot",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<BlockItem> GOLDHEART_BLOCK_ITEM = addToTab(ITEMS.register("goldheart_block",
            () -> new BlockItem(BlockInit.GOLDHEART_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<Item> HEARTBREAK_INGOT = addToTab(ITEMS.register("heartbreak_ingot",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<BlockItem> HEARTBREAK_BLOCK_ITEM = addToTab(ITEMS.register("heartbreak_block",
            () -> new BlockItem(BlockInit.HEARTBREAK_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<Item> OATHBOUND_INGOT = addToTab(ITEMS.register("oathbound_ingot",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<Item> VOIDHEART_INGOT = addToTab(ITEMS.register("voidheart_ingot",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<Item> PASSIONFRUIT = addToTab(ITEMS.register("passionfruit",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .effect(() -> new MobEffectInstance(EffectsInit.FLUSTERED.get(), 200, 0, true, true), 1f)
                            .build()
                    )
            )
    ));
    public static final RegistryObject<Item> PASSIONFRUIT_SEEDS = addToTab(ITEMS.register("passionfruit_seeds",
            () -> new ItemNameBlockItem(BlockInit.PASSIONFRUIT_CROP.get(), new Item.Properties())
    ));

    public static final RegistryObject<Item> RAW_JITTERBUG_MEAT = addToTab(ITEMS.register("raw_jitterbug_meat",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1, true, true), .01f)
                            .build()
                    )
            )
    ));
    public static final RegistryObject<Item> COOKED_JITTERBUG_MEAT = addToTab(ITEMS.register("cooked_jitterbug_meat",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(7.2f)
                            .build()
                    )
            )
    ));
    public static final RegistryObject<ForgeSpawnEggItem> JITTERBUG_SPAWN_EGG = addToTab(ITEMS.register("jitterbug_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.JITTERBUG, 0xE50EBA, 0xED84D7, new Item.Properties())
    ));
    public static final RegistryObject<BlockItem> OATHBOUND_BLOCK_ITEM = addToTab(ITEMS.register("oathbound_block",
            () -> new BlockItem(BlockInit.OATHBOUND_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));
    public static final RegistryObject<BlockItem> VOIDHEART_BLOCK_ITEM = addToTab(ITEMS.register("voidheart_block",
            () -> new BlockItem(BlockInit.VOIDHEART_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<CustomSword> GOLDHEART_SWORD = addToTab(ITEMS.register("goldheart_sword",
            () -> new CustomSword(TiersInit.GOLDHEART, 7, -2.4f, new Item.Properties() //attack speed is in attacks per second, so higher for faster
                    .rarity(Rarity.RARE)
            )
                    .addEffect(MobEffects.WEAKNESS, 2, 60)
    ));

    public static final RegistryObject<CustomArmorItem> GOLDHEART_HELMET = addToTab(ITEMS.register("goldheart_helmet",
            () -> new CustomArmorItem(ArmorMaterialInit.GOLDHEART, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));
    public static final RegistryObject<CustomArmorItem> GOLDHEART_CHESTPLATE = addToTab(ITEMS.register("goldheart_chestplate",
            () -> new CustomArmorItem(ArmorMaterialInit.GOLDHEART, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
                    .addEffect(MobEffects.REGENERATION, 1)
                    .addEffect(MobEffects.MOVEMENT_SPEED, 1)
                    .addEffect(MobEffects.ABSORPTION, 1)
    ));
    public static final RegistryObject<CustomArmorItem> GOLDHEART_LEGGINGS = addToTab(ITEMS.register("goldheart_leggings",
            () -> new CustomArmorItem(ArmorMaterialInit.GOLDHEART, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));
    public static final RegistryObject<CustomArmorItem> GOLDHEART_BOOTS = addToTab(ITEMS.register("goldheart_boots",
            () -> new CustomArmorItem(ArmorMaterialInit.GOLDHEART, ArmorItem.Type.BOOTS, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<CustomSword> HEARTBREAK_SWORD = addToTab(ITEMS.register("heartbreak_sword",
            () -> new CustomSword(TiersInit.HEARTBREAK, 7, -2.4f, new Item.Properties() //attack speed is in attacks per second, so higher for faster
                    .rarity(Rarity.RARE)
            )
                    .addEffect(MobEffects.CONFUSION, 2, 60)
    ));

    public static final RegistryObject<CustomArmorItem> HEARTBREAK_HELMET = addToTab(ITEMS.register("heartbreak_helmet",
            () -> new CustomArmorItem(ArmorMaterialInit.HEARTBREAK, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));
    public static final RegistryObject<CustomArmorItem> HEARTBREAK_CHESTPLATE = addToTab(ITEMS.register("heartbreak_chestplate",
            () -> new CustomArmorItem(ArmorMaterialInit.HEARTBREAK, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
                    .addEffect(MobEffects.DAMAGE_BOOST, 1)
                    .addEffect(MobEffects.MOVEMENT_SLOWDOWN, 0)
                    .addEffect(EffectsInit.THORNS.get(), 0)
    ));
    public static final RegistryObject<CustomArmorItem> HEARTBREAK_LEGGINGS = addToTab(ITEMS.register("heartbreak_leggings",
            () -> new CustomArmorItem(ArmorMaterialInit.HEARTBREAK, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));
    public static final RegistryObject<CustomArmorItem> HEARTBREAK_BOOTS = addToTab(ITEMS.register("heartbreak_boots",
            () -> new CustomArmorItem(ArmorMaterialInit.HEARTBREAK, ArmorItem.Type.BOOTS, new Item.Properties()
                    .rarity(Rarity.RARE)
            )
    ));

    public static final RegistryObject<CustomSword> OATHBOUND_SWORD = addToTab(ITEMS.register("oathbound_sword",
            () -> new CustomSword(TiersInit.OATHBOUND, 8, -1f, new Item.Properties() //attack speed is in attacks per second, so higher for faster
                    .rarity(Rarity.EPIC)
            )
                    .addEffect(MobEffects.WEAKNESS, 3, 60)
                    .addEffect(MobEffects.GLOWING, 0, 100)
    ));

    public static final RegistryObject<CustomArmorItem> OATHBOUND_HELMET = addToTab(ITEMS.register("oathbound_helmet",
            () -> new CustomArmorItem(ArmorMaterialInit.OATHBOUND, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));
    public static final RegistryObject<CustomArmorItem> OATHBOUND_CHESTPLATE = addToTab(ITEMS.register("oathbound_chestplate",
            () -> new CustomArmorItem(ArmorMaterialInit.OATHBOUND, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
                    .addEffect(MobEffects.REGENERATION, 1)
                    .addEffect(MobEffects.MOVEMENT_SPEED, 2)
                    .addEffect(MobEffects.ABSORPTION, 2)
                    .addEffect(MobEffects.SLOW_FALLING, 0)
    ));
    public static final RegistryObject<CustomArmorItem> OATHBOUND_LEGGINGS = addToTab(ITEMS.register("oathbound_leggings",
            () -> new CustomArmorItem(ArmorMaterialInit.OATHBOUND, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));
    public static final RegistryObject<CustomArmorItem> OATHBOUND_BOOTS = addToTab(ITEMS.register("oathbound_boots",
            () -> new CustomArmorItem(ArmorMaterialInit.OATHBOUND, ArmorItem.Type.BOOTS, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<CustomSword> VOIDHEART_SWORD = addToTab(ITEMS.register("voidheart_sword",
            () -> new CustomSword(TiersInit.VOIDHEART, 8, -1f, new Item.Properties() //attack speed is in attacks per second, so higher for faster
                    .rarity(Rarity.EPIC)
            )
                    .addEffect(MobEffects.WITHER, 0, 60)
                    .addEffect(MobEffects.DARKNESS, 0, 100)
    ));

    public static final RegistryObject<CustomArmorItem> VOIDHEART_HELMET = addToTab(ITEMS.register("voidheart_helmet",
            () -> new CustomArmorItem(ArmorMaterialInit.VOIDHEART, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));
    public static final RegistryObject<CustomArmorItem> VOIDHEART_CHESTPLATE = addToTab(ITEMS.register("voidheart_chestplate",
            () -> new CustomArmorItem(ArmorMaterialInit.VOIDHEART, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
                    .addEffect(MobEffects.DAMAGE_BOOST, 1)
                    .addEffect(MobEffects.MOVEMENT_SLOWDOWN, 1)
                    .addEffect(EffectsInit.THORNS.get(), 2)
                    .addEffect(MobEffects.DAMAGE_RESISTANCE, 0)
    ));
    public static final RegistryObject<CustomArmorItem> VOIDHEART_LEGGINGS = addToTab(ITEMS.register("voidheart_leggings",
            () -> new CustomArmorItem(ArmorMaterialInit.VOIDHEART, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));
    public static final RegistryObject<CustomArmorItem> VOIDHEART_BOOTS = addToTab(ITEMS.register("voidheart_boots",
            () -> new CustomArmorItem(ArmorMaterialInit.VOIDHEART, ArmorItem.Type.BOOTS, new Item.Properties()
                    .rarity(Rarity.EPIC)
            )
    ));

    public static final RegistryObject<LoveWand> LOVE_WAND = addToTab(ITEMS.register("love_wand",
            () -> new LoveWand(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
            ,350)
    ));
}

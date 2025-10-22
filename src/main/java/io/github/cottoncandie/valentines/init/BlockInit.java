package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.blocks.PassionfruitCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Valentines.MODID);

    public static final RegistryObject<PassionfruitCropBlock> PASSIONFRUIT_CROP = BLOCKS.register("passionfruit_crop",
            () -> new PassionfruitCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission())
    );

    public static final RegistryObject<DropExperienceBlock> PASSIONITE_ORE = BLOCKS.register("passionite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .strength(5.0f, 17f)
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> 5)
                    .requiresCorrectToolForDrops(),

                    UniformInt.of(4, 7)
            ));

    public static final RegistryObject<DropExperienceBlock> DEEPSLATE_PASSIONITE_ORE = BLOCKS.register("deepslate_passionite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .strength(5.0f, 17f)
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> 5)
                    .requiresCorrectToolForDrops(),

                    UniformInt.of(4, 7)
            ));

    public static final RegistryObject<DropExperienceBlock> OBSIDIAN_ROSE_ORE = BLOCKS.register("obsidian_rose_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(5.0f, 17f)
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> 5)
                    .requiresCorrectToolForDrops(),

                    UniformInt.of(5, 10)
            ));


    public static final RegistryObject<Block> GOLDHEART_BLOCK = BLOCKS.register("goldheart_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PINK)
                    .strength(5.0f, 17f)
                    .sound(SoundType.AMETHYST)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> HEARTBREAK_BLOCK = BLOCKS.register("heartbreak_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(5.0f, 17f)
                    .sound(SoundType.BONE_BLOCK)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> OATHBOUND_BLOCK = BLOCKS.register("oathbound_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PINK)
                    .strength(5.0f, 17f)
                    .sound(SoundType.AMETHYST)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> VOIDHEART_BLOCK = BLOCKS.register("voidheart_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(5.0f, 17f)
                    .sound(SoundType.SOUL_SAND)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));


}
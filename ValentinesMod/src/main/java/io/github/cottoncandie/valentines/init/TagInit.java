package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit {
    public static final TagKey<Block> NEEDS_PASSIONITE_TOOL = tag("needs_passionite_tool");
    public static final TagKey<Block> NEEDS_OBSIDIAN_ROSE_TOOL = tag("needs_obsidian_rose_tool");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Valentines.MODID, name));
    }
}

package io.github.cottoncandie.valentines.init;

import io.github.cottoncandie.valentines.Valentines;

import io.github.cottoncandie.valentines.entity.Jitterbug;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Valentines.MODID);

    public static final RegistryObject<EntityType<Jitterbug>> JITTERBUG = ENTITIES.register("jitterbug",
            () ->EntityType.Builder.<Jitterbug>of(Jitterbug::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(Valentines.MODID, "jitterbug").toString())
    );
}

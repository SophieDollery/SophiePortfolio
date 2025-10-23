package io.github.cottoncandie.valentines.events;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.entity.Jitterbug;
import io.github.cottoncandie.valentines.init.BlockInit;
import io.github.cottoncandie.valentines.init.EntityInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.JITTERBUG.get(), Jitterbug.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(EntityInit.JITTERBUG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Jitterbug::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerEvents(final FMLCommonSetupEvent event) {
        // Register event listener manually
        MinecraftForge.EVENT_BUS.addListener(CommonModEvents::onPlayerRightClickBlock);
    }

    // This method does not need the @SubscribeEvent annotation
    public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        // Get the player (entity) performing the action
        Player player = (Player) event.getEntity();  // Corrected to use getEntity()
    }
}

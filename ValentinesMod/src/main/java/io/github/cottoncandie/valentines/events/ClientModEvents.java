package io.github.cottoncandie.valentines.events;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.client.model.JitterbugModel;
import io.github.cottoncandie.valentines.client.renderer.JitterbugRenderer;
import io.github.cottoncandie.valentines.init.EntityInit;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Valentines.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.JITTERBUG.get(), JitterbugRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JitterbugModel.LAYER_LOCATION, JitterbugModel::createBodyLayer);
    }
}

package io.github.cottoncandie.valentines.client.renderer;

import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.entity.Jitterbug;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import io.github.cottoncandie.valentines.client.model.JitterbugModel;

public class JitterbugRenderer extends MobRenderer<Jitterbug, JitterbugModel<Jitterbug>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Valentines.MODID, "textures/entity/jitterbug.png");

    public JitterbugRenderer(EntityRendererProvider.Context context) {
        super(context, new JitterbugModel<>(context.bakeLayer(JitterbugModel.LAYER_LOCATION)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(Jitterbug entity) {
        return TEXTURE;
    }
}
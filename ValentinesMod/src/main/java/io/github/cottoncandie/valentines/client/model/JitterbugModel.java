package io.github.cottoncandie.valentines.client.model;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.cottoncandie.valentines.Valentines;
import io.github.cottoncandie.valentines.entity.Jitterbug;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class JitterbugModel<T extends Jitterbug> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Valentines.MODID, "jitterbug"), "main");
	private final ModelParts parts;
	private final ModelPart jitterbug;

	public JitterbugModel(ModelPart root) {
		this.jitterbug = root.getChild("jitterbug");
		ModelPart shell = jitterbug.getChild("shell");
		ModelPart leg1 = jitterbug.getChild("leg1");
		ModelPart leg2 = jitterbug.getChild("leg2");
		ModelPart leg3 = jitterbug.getChild("leg3");
		ModelPart leg4 = jitterbug.getChild("leg4");
		ModelPart leg5 = jitterbug.getChild("leg5");
		ModelPart leg6 = jitterbug.getChild("leg6");
		ModelPart head = jitterbug.getChild("head");

		parts = new ModelParts(jitterbug, head, shell, leg1, leg2, leg3, leg4, leg5, leg6);
	}

	public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition jitterbug = partdefinition.addOrReplaceChild("jitterbug", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

        PartDefinition shell = jitterbug.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg1 = jitterbug.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 1.0F, -4.0F));

        PartDefinition leg2 = jitterbug.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.0F, -4.0F));

        PartDefinition leg3 = jitterbug.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 1.0F, 0.0F));

        PartDefinition leg4 = jitterbug.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.0F, 0.0F));

        PartDefinition leg5 = jitterbug.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 1.0F, 4.0F));

        PartDefinition leg6 = jitterbug.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.0F, 4.0F));

        PartDefinition head = jitterbug.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 22).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Jitterbug entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float scale = entity.isBaby() ? 0.5f:1f;
        this.parts.body().xScale = scale;
        this.parts.body().yScale = scale;
        this.parts.body().zScale = scale;

		this.parts.head().yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.parts.head().xRot = headPitch * ((float)Math.PI / 180f);

		//left legs
		this.parts.leg1().xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		this.parts.leg4().xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		this.parts.leg5().xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;

		//right legs
		this.parts.leg2().xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
		this.parts.leg3().xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
		this.parts.leg6().xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		jitterbug.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private record ModelParts(ModelPart body, ModelPart head, ModelPart shell, ModelPart leg1, ModelPart leg2, ModelPart leg3, ModelPart leg4, ModelPart leg5, ModelPart leg6) {

	}
}
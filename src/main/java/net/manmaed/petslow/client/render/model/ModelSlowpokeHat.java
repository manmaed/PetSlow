package net.manmaed.petslow.client.render.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

public class ModelSlowpokeHat<T extends Entity> extends Model {

	public final ModelPart hat;


	public ModelSlowpokeHat(ModelPart root) {
		super(RenderType::entityCutout);
		this.hat = root.getChild("hat");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}


	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		/*poseStack.pushPose();
		poseStack.scale((float) 0.55D, (float) 0.55D, (float) 0.55D);
		poseStack.translate(0f, -0.12f, 0f);*/
		hat.render(poseStack, buffer, packedLight, packedOverlay);
		/*poseStack.popPose();*/
	}
}
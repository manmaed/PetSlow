package net.manmaed.petslow.client.render.model;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

public class ModelChair<T extends Entity> extends Model {
	private final ModelPart root;

	public ModelChair(ModelPart root) {
        super(RenderType::entitySolid);
        this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(13, 0).mirror().addBox(-3.7658F, 2.023F, -3.7433F, 8.0316F, 1.3386F, 8.0316F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(-3.7658F, -4.67F, 2.2804F, 8.0316F, 4.0158F, 2.0079F, new CubeDeformation(0.0F))
		.texOffs(0, 10).mirror().addBox(-3.2638F, -0.6542F, 2.6151F, 1.3386F, 2.6772F, 1.3386F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 10).mirror().addBox(2.4862F, -0.6542F, 2.6151F, 1.3386F, 2.6772F, 1.3386F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).addBox(-3.6594F, 6.7081F, 2.2567F, 2.0079F, 1.3386F, 2.0079F, new CubeDeformation(0.0F))
		.texOffs(19, 11).addBox(-3.3248F, 3.3616F, 2.5914F, 1.3386F, 3.3465F, 1.3386F, new CubeDeformation(0.0F))
		.texOffs(19, 11).addBox(-3.3248F, 3.3616F, -3.4086F, 1.3386F, 3.3465F, 1.3386F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-3.6594F, 6.7081F, -3.7433F, 2.0079F, 1.3386F, 2.0079F, new CubeDeformation(0.0F))
		.texOffs(6, 10).addBox(-2.9901F, 5.0349F, -2.0701F, 0.6693F, 0.6693F, 4.6851F, new CubeDeformation(0.0F))
		.texOffs(19, 11).addBox(2.4252F, 3.3616F, -3.4086F, 1.3386F, 3.3465F, 1.3386F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(2.0906F, 6.7081F, -3.7433F, 2.0079F, 1.3386F, 2.0079F, new CubeDeformation(0.0F))
		.texOffs(6, 10).addBox(2.7599F, 5.0349F, -2.0701F, 0.6693F, 0.6693F, 4.6851F, new CubeDeformation(0.0F))
		.texOffs(19, 11).addBox(2.4252F, 3.3616F, 2.5914F, 1.3386F, 3.3465F, 1.3386F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(2.0906F, 6.7081F, 2.2567F, 2.0079F, 1.3386F, 2.0079F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int ihavenocluetrynegone) {
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
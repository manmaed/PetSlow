package net.manmaed.petslow.client.render.model;

// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

//Copyed From PetRock With perms

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

//Copyed From PetRock With perms

public class ModelSantaHat extends Model {

    private final ModelPart HatBottem;
    private final ModelPart hatp1;
    private final ModelPart hatp2;
    private final ModelPart hatp3;
    private final ModelPart hatp4;
    private final ModelPart hatp5;
    private final ModelPart ballball;

    public ModelSantaHat(ModelPart root) {
        super(RenderType::entitySolid);
        this.HatBottem = root.getChild("HatBottem");
        this.hatp1 = root.getChild("hatp1");
        this.hatp2 = root.getChild("hatp2");
        this.hatp3 = root.getChild("hatp3");
        this.hatp4 = root.getChild("hatp4");
        this.hatp5 = root.getChild("hatp5");
        this.ballball = root.getChild("ballball");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition HatBottem = partdefinition.addOrReplaceChild("HatBottem", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, 32.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition hatp1 = partdefinition.addOrReplaceChild("hatp1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 32.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition hatp2 = partdefinition.addOrReplaceChild("hatp2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 33.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition hatp3 = partdefinition.addOrReplaceChild("hatp3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 32.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition hatp4 = partdefinition.addOrReplaceChild("hatp4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 32.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition hatp5 = partdefinition.addOrReplaceChild("hatp5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 29.2F, 13.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.6F, 0.0F, -0.4014F, 0.0F, 0.0F));

        PartDefinition ballball = partdefinition.addOrReplaceChild("ballball", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 29.2F, 12.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.2F, 2.1F, -0.4014F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        HatBottem.render(poseStack, buffer, packedLight, packedOverlay);
        hatp1.render(poseStack, buffer, packedLight, packedOverlay);
        hatp2.render(poseStack, buffer, packedLight, packedOverlay);
        hatp3.render(poseStack, buffer, packedLight, packedOverlay);
        hatp4.render(poseStack, buffer, packedLight, packedOverlay);
        hatp5.render(poseStack, buffer, packedLight, packedOverlay);
        ballball.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
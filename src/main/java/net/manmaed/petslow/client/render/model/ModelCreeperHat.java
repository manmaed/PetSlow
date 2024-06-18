package net.manmaed.petslow.client.render.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

public class ModelCreeperHat<T extends Entity> extends Model {
    private final ModelPart foot2F;
    private final ModelPart foot1B;
    private final ModelPart CreepsHead;
    private final ModelPart CreepesBody;
    private final ModelPart foot1F;
    private final ModelPart foot2B;

    public ModelCreeperHat(ModelPart root) {
        super(RenderType::entitySolid);
        this.foot2F = root.getChild("foot2F");
        this.foot1B = root.getChild("foot1B");
        this.CreepsHead = root.getChild("CreepsHead");
        this.CreepesBody = root.getChild("CreepesBody");
        this.foot1F = root.getChild("foot1F");
        this.foot2B = root.getChild("foot2B");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition foot2F = partdefinition.addOrReplaceChild("foot2F", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 31.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -9.0F, -1.0F));

        PartDefinition foot1B = partdefinition.addOrReplaceChild("foot1B", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 31.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -9.0F, 1.5F));

        PartDefinition CreepsHead = partdefinition.addOrReplaceChild("CreepsHead", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 30.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition CreepesBody = partdefinition.addOrReplaceChild("CreepesBody", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, 29.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition foot1F = partdefinition.addOrReplaceChild("foot1F", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 31.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -9.0F, -1.0F));

        PartDefinition foot2B = partdefinition.addOrReplaceChild("foot2B", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 31.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -9.0F, 1.5F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int ihavenocluetrynegone) {
        foot2F.render(poseStack, buffer, packedLight, packedOverlay);
        foot1B.render(poseStack, buffer, packedLight, packedOverlay);
        CreepsHead.render(poseStack, buffer, packedLight, packedOverlay);
        CreepesBody.render(poseStack, buffer, packedLight, packedOverlay);
        foot1F.render(poseStack, buffer, packedLight, packedOverlay);
        foot2B.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
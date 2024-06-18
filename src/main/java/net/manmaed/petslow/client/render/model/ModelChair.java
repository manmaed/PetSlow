package net.manmaed.petslow.client.render.model;
// Made with Tabula
// Expoted with Blockbench 4.1.5


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

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 19.0F, 0.4F));
        PartDefinition chairback = root.addOrReplaceChild("chairback", CubeListBuilder.create().texOffs(0, 9).addBox(-2.5F, 0.0F, -0.5F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, 2.0F));
        PartDefinition leg4 = root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 19.0F, 0.4F));
        PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 19.0F, 0.4F));
        PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 19.0F, 0.4F));
        PartDefinition chairbase = root.addOrReplaceChild("chairbase", CubeListBuilder.create().texOffs(0, 2).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -0.3F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int ihavenocluetrynegone) {
        root.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
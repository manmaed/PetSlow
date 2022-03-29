package net.manmaed.petslow.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

//Copyed From PetRock With perms

public class ModelCakeHat extends Model {

    private final ModelPart cake;

    public ModelCakeHat(ModelPart root) {
        super(RenderType::entitySolid);
        this.cake = root.getChild("cake");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition cake = partdefinition.addOrReplaceChild("cake", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 30.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        cake.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
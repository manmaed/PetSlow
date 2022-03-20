package net.manmaed.petslow.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

/**
 * test - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelSign<T extends EntityPetSlow> extends Model {
    private final ModelPart sign;

    public ModelSign(ModelPart root) {
        super(RenderType::entitySolid);
        this.sign = root.getChild("sign");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition sign = partdefinition.addOrReplaceChild("sign", CubeListBuilder.create().texOffs(0, 0).addBox(-31.0F, -39.0F, 0.0F, 64.0F, 39.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        sign.render(poseStack, buffer, packedLight, packedOverlay);
    }
}

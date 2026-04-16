package com.agricraft.agricraft.common.util.neoforge;

import com.agricraft.agricraft.common.util.PlatformClient;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/**
 * NeoForge implementation of {@link PlatformClient}
 */
public class NeoForgePlatformClient extends PlatformClient {

	private static RenderType getEntityRenderType(RenderType chunkRenderType, boolean cull) {
		if (chunkRenderType != RenderType.translucent()) {
			return Sheets.cutoutBlockSheet();
		}
		return cull || !Minecraft.useShaderTransparency() ? Sheets.translucentCullBlockSheet() : Sheets.translucentItemSheet();
	}

	@Override
	public void renderItem(BakedModel model, ItemStack stack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
		ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();

		poseStack.popPose();
		poseStack.pushPose();

		model = model.applyTransform(itemDisplayContext, poseStack, isLeftHand(itemDisplayContext));
		poseStack.translate(-.5, -.5, -.5);

		boolean glint = stack.hasFoil();
		RenderType type = getEntityRenderType(RenderType.cutoutMipped(), true);
		VertexConsumer consumer = ItemRenderer.getFoilBuffer(buffer, type, true, glint);
		renderer.renderModelLists(model, stack, packedLight, packedOverlay, poseStack, consumer);
	}

	private static boolean isLeftHand(ItemDisplayContext itemDisplayContext) {
		return itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
	}

	@Override
	public BakedModel getStandaloneModel(ResourceLocation id) {
		return Minecraft.getInstance().getModelManager().bakedRegistry.get(ModelResourceLocation.standalone(id));
	}

}

package com.agricraft.agricraft.client.neoforge;

import com.agricraft.agricraft.api.AgriApi;
import com.agricraft.agricraft.client.AgriCraftClient;
import com.agricraft.agricraft.client.ber.CropBlockEntityRenderer;
import com.agricraft.agricraft.client.ber.SeedAnalyzerEntityRenderer;
import com.agricraft.agricraft.client.gui.MagnifyingGlassOverlay;
import com.agricraft.agricraft.client.gui.SeedAnalyzerScreen;
import com.agricraft.agricraft.common.config.neoforge.NeoForgeMenuConfig;
import com.agricraft.agricraft.common.registry.ModBlockEntityTypes;
import com.agricraft.agricraft.common.registry.ModBlocks;
import com.agricraft.agricraft.common.registry.ModMenus;
import com.agricraft.agricraft.common.util.PlatformClient;
import com.agricraft.agricraft.common.util.neoforge.NeoForgePlatformClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

import java.util.Map;

/**
 * NeoForge client event handler in the mod event bus
 */
@EventBusSubscriber(modid = AgriApi.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AgriCraftNeoForgeClient {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		PlatformClient.setup(new NeoForgePlatformClient());
		AgriCraftNeoForgeClient.init();
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SEED_ANALYZER.get(), RenderType.cutout());
	}

	@SubscribeEvent
	public static void loadModels(ModelEvent.RegisterAdditional event) {
		for (Map.Entry<ResourceLocation, Resource> entry : FileToIdConverter.json("models/seed").listMatchingResources(Minecraft.getInstance().getResourceManager()).entrySet()) {
			ResourceLocation seed = new ResourceLocation(entry.getKey().toString().replace("models/seed", "seed").replace(".json", ""));
			event.register(seed);
		}
		for (Map.Entry<ResourceLocation, Resource> entry : FileToIdConverter.json("models/crop").listMatchingResources(Minecraft.getInstance().getResourceManager()).entrySet()) {
			ResourceLocation seed = new ResourceLocation(entry.getKey().toString().replace("models/crop", "crop").replace(".json", ""));
			event.register(seed);
		}
		for (Map.Entry<ResourceLocation, Resource> entry : FileToIdConverter.json("models/weed").listMatchingResources(Minecraft.getInstance().getResourceManager()).entrySet()) {
			ResourceLocation seed = new ResourceLocation(entry.getKey().toString().replace("models/weed", "weed").replace(".json", ""));
			event.register(seed);
		}
		event.register(new ResourceLocation("agricraft:block/wooden_crop_sticks"));
		event.register(new ResourceLocation("agricraft:block/iron_crop_sticks"));
		event.register(new ResourceLocation("agricraft:block/obsidian_crop_sticks"));
		event.register(new ResourceLocation("agricraft:block/wooden_cross_crop_sticks"));
		event.register(new ResourceLocation("agricraft:block/iron_cross_crop_sticks"));
		event.register(new ResourceLocation("agricraft:block/obsidian_cross_crop_sticks"));
	}

	@SubscribeEvent
	public static void registerBer(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntityTypes.CROP.get(), CropBlockEntityRenderer::new);
		event.registerBlockEntityRenderer(ModBlockEntityTypes.SEED_ANALYZER.get(), SeedAnalyzerEntityRenderer::new);
	}

	@SubscribeEvent
	public static void registerGuiOverlays(RegisterGuiLayersEvent event) {
		event.registerAbove(VanillaGuiLayers.HOTBAR, new ResourceLocation(AgriApi.MOD_ID, "magnifying_glass_info"), (guiGraphics, partialTicks) -> MagnifyingGlassOverlay.renderOverlay(guiGraphics, partialTicks));
	}

	@SubscribeEvent
	public static void registerMenuScreens(net.neoforged.neoforge.client.event.RegisterMenuScreensEvent event) {
		event.register(ModMenus.SEED_ANALYZER_MENU.get(), SeedAnalyzerScreen::new);
	}

	public static void init() {
		AgriCraftClient.init();
		ModList.get().getModContainerById(AgriApi.MOD_ID).ifPresent(NeoForgeMenuConfig::register);
	}

}

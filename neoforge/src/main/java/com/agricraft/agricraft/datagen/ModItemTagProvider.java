package com.agricraft.agricraft.datagen;

import com.agricraft.agricraft.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

	public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, modId, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		// Fabric
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:seeds")))
				.add(ModItems.SEED.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:coal_nuggets")))
				.add(ModItems.COAL_PEBBLE.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:copper_nuggets")))
				.add(ModItems.COPPER_NUGGET.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:diamond_nuggets")))
				.add(ModItems.DIAMOND_SHARD.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:emerald_nuggets")))
				.add(ModItems.EMERALD_SHARD.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("c:quartz_nuggets")))
				.add(ModItems.QUARTZ_SHARD.get());

		// Forge
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:seeds")))
				.add(ModItems.SEED.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:nuggets/coal")))
				.add(ModItems.COAL_PEBBLE.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:nuggets/copper")))
				.add(ModItems.COPPER_NUGGET.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:nuggets/diamond")))
				.add(ModItems.DIAMOND_SHARD.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:nuggets/emerald")))
				.add(ModItems.EMERALD_SHARD.get());
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("forge:nuggets/quartz")))
				.add(ModItems.QUARTZ_SHARD.get());

		// Cross-Compatibility
		//     Recipes
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:rods/wooden")))
				.add(Items.STICK)
				.addOptionalTag(ResourceLocation.parse("c:wooden_rods"))
				.addOptionalTag(ResourceLocation.parse("forge:rods/wooden"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/iron")))
				.add(Items.IRON_NUGGET)
				.addOptionalTag(ResourceLocation.parse("c:iron_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/iron"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:obsidian")))
				.add(Items.OBSIDIAN)
				.addOptionalTag(ResourceLocation.parse("c:obsidian"))
				.addOptionalTag(ResourceLocation.parse("forge:obsidian"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:seeds")))
				.add(Items.BEETROOT_SEEDS)
				.add(Items.MELON_SEEDS)
				.add(Items.PUMPKIN_SEEDS)
				.add(Items.WHEAT_SEEDS)
				.addOptionalTag(ResourceLocation.parse("c:seeds"))
				.addOptionalTag(ResourceLocation.parse("forge:seeds"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:ingots/iron")))
				.add(Items.IRON_INGOT)
				.addOptionalTag(ResourceLocation.parse("c:iron_ingots"))
				.addOptionalTag(ResourceLocation.parse("forge:ingots/iron"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:glass_panes/colorless")))
				.add(Items.GLASS_PANE)
				.addOptionalTag(ResourceLocation.parse("c:clear_glass_panes"))
				.addOptionalTag(ResourceLocation.parse("forge:glass_panes/colorless"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:fences/wooden")))
				.addOptionalTag(ResourceLocation.parse("minecraft:wooden_fences")) // Not sure why this tag isn't available during datagen?
				.addOptionalTag(ResourceLocation.parse("c:wooden_fences"))
				.addOptionalTag(ResourceLocation.parse("forge:fences/wooden"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:string")))
				.add(Items.STRING)
				.addOptionalTag(ResourceLocation.parse("c:string"))
				.addOptionalTag(ResourceLocation.parse("c:strings"))
				.addOptionalTag(ResourceLocation.parse("forge:string"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:leather")))
				.add(Items.LEATHER)
				.addOptionalTag(ResourceLocation.parse("c:leather"))
				.addOptionalTag(ResourceLocation.parse("c:leathers"))
				.addOptionalTag(ResourceLocation.parse("forge:leather"));
		//     Plants (produce)
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:dusts/glowstone")))
				.add(Items.GLOWSTONE_DUST)
				.addOptionalTag(ResourceLocation.parse("c:glowstone_dusts"))
				.addOptionalTag(ResourceLocation.parse("forge:dusts/glowstone"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:dusts/redstone")))
				.add(Items.REDSTONE)
				.addOptionalTag(ResourceLocation.parse("c:redstone_dusts"))
				.addOptionalTag(ResourceLocation.parse("forge:dusts/redstone"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:gems/lapis")))
				.add(Items.LAPIS_LAZULI)
				.addOptionalTag(ResourceLocation.parse("c:lapis"))
				.addOptionalTag(ResourceLocation.parse("c:lapis_gems"))
				.addOptionalTag(ResourceLocation.parse("forge:gems/lapis"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/aluminium")))
				.addOptionalTag(ResourceLocation.parse("c:aluminum_nuggets"))
				.addOptionalTag(ResourceLocation.parse("c:aluminium_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/aluminum"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/aluminium"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/coal")))
				.add(ModItems.COAL_PEBBLE.get())
				.addOptionalTag(ResourceLocation.parse("c:coal_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/coal"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/copper")))
				.add(ModItems.COPPER_NUGGET.get())
				.addOptionalTag(ResourceLocation.parse("c:copper_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/copper"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/diamond")))
				.add(ModItems.DIAMOND_SHARD.get())
				.addOptionalTag(ResourceLocation.parse("c:diamond_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/diamond"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/emerald")))
				.add(ModItems.EMERALD_SHARD.get())
				.addOptionalTag(ResourceLocation.parse("c:emerald_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/emerald"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/gold")))
				.add(Items.GOLD_NUGGET)
				.addOptionalTag(ResourceLocation.parse("c:gold_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/gold"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/iron")))
				.add(Items.IRON_NUGGET)
				.addOptionalTag(ResourceLocation.parse("c:iron_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/iron"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/lead")))
				.addOptionalTag(ResourceLocation.parse("c:lead_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/lead"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/nickel")))
				.addOptionalTag(ResourceLocation.parse("c:nickel_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/nickel"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/osmium")))
				.addOptionalTag(ResourceLocation.parse("c:osmium_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/osmium"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/platinum")))
				.addOptionalTag(ResourceLocation.parse("c:platinum_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/platinum"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/quartz")))
				.add(ModItems.QUARTZ_SHARD.get())
				.addOptionalTag(ResourceLocation.parse("c:quartz_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/quartz"));
		this.tag(TagKey.create(Registries.ITEM, ResourceLocation.parse("agricraft:nuggets/tin")))
				.addOptionalTag(ResourceLocation.parse("c:tin_nuggets"))
				.addOptionalTag(ResourceLocation.parse("forge:nuggets/tin"));
	}

}

package com.agricraft.agricraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Cross-Compatibility
        //     Plants (blocks)
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/aluminium")))
                .addOptionalTag(ResourceLocation.parse("c:aluminum_ores"))
                .addOptionalTag(ResourceLocation.parse("c:aluminium_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/aluminum"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/aluminium"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/coal")))
                .add(Blocks.COAL_ORE)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:coal_ores"))
                .addOptionalTag(ResourceLocation.parse("c:coal_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/coal"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/copper")))
                .add(Blocks.COPPER_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:copper_ores"))
                .addOptionalTag(ResourceLocation.parse("c:copper_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/copper"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/diamond")))
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:diamond_ores"))
                .addOptionalTag(ResourceLocation.parse("c:diamond_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/diamond"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/emerald")))
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:emerald_ores"))
                .addOptionalTag(ResourceLocation.parse("c:emerald_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/emerald"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/gold")))
                .add(Blocks.GOLD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:gold_ores"))
                .addOptionalTag(ResourceLocation.parse("c:gold_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/gold"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/iron")))
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:iron_ores"))
                .addOptionalTag(ResourceLocation.parse("c:iron_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/iron"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/lapis")))
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .addOptionalTag(ResourceLocation.parse("minecraft:lapis_ores"))
                .addOptionalTag(ResourceLocation.parse("c:lapis_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/lapis"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/lead")))
                .addOptionalTag(ResourceLocation.parse("c:lead_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/lead"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/netherite_scrap")))
                .add(Blocks.ANCIENT_DEBRIS)
                .addOptionalTag(ResourceLocation.parse("c:netherite_scrap_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/netherite_scrap"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/nickel")))
                .addOptionalTag(ResourceLocation.parse("c:nickel_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/nickel"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/osmium")))
                .addOptionalTag(ResourceLocation.parse("c:osmium_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/osmium"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/platinum")))
                .addOptionalTag(ResourceLocation.parse("c:platinum_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/platinum"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/quartz")))
                .add(Blocks.NETHER_QUARTZ_ORE)
                .addOptionalTag(ResourceLocation.parse("c:quartz_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/quartz"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/redstone")))
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .addOptionalTag(ResourceLocation.parse("c:redstone_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/redstone"));
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.parse("agricraft:ores/tin")))
                .addOptionalTag(ResourceLocation.parse("c:tin_ores"))
                .addOptionalTag(ResourceLocation.parse("forge:ores/tin"));
    }
}

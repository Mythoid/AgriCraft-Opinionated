package com.agricraft.agricraft.api.genetic;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public interface AgriGenomeProviderItem {

	/**
	 * Change the genome of the plant.
	 * @param genome the new genome of the crop
	 */
	default void setGenome(ItemStack stack, AgriGenome genome) {
		genome.writeToNBT(stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag());
	}

	default Optional<AgriGenome> getGenome(ItemStack stack) {
		return Optional.ofNullable(AgriGenome.fromNBT(stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()));
	}

}

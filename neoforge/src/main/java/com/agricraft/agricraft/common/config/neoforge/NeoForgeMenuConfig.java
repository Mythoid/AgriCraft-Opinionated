package com.agricraft.agricraft.common.config.neoforge;

import com.agricraft.agricraft.AgriCraft;
import com.agricraft.agricraft.api.config.AgriCraftConfig;
import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.api.types.ResourcefulConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class NeoForgeMenuConfig {

	/**
	 * Register our configuration menu to the modlist menu
	 */
	public static void register(ModContainer container) {
		container.registerExtensionPoint(IConfigScreenFactory.class, (minecraft, parent) -> {
			ResourcefulConfig config = AgriCraft.CONFIGURATOR.getConfig(AgriCraftConfig.class);
			if (config == null) {
				return null;
			}
			return new ConfigScreen(null, config);
		});
	}

}

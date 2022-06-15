package net.parcival.wardium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.parcival.wardium.item.ModItems;
import net.parcival.wardium.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wardium implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("wardium");
	public static final String MOD_ID = "wardium";

	public static final ItemGroup WARDIUM_GROUP = FabricItemGroupBuilder.build(new Identifier(Wardium.MOD_ID, "wardium"),
			() -> new ItemStack(ModItems.WARDIUM));

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Wardium Mod");
		ModItems.registerModItems();
		ModRegistries.registerModStuff();

	}
}

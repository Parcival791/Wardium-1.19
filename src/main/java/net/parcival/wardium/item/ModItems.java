package net.parcival.wardium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.parcival.wardium.Wardium;
import net.parcival.wardium.item.custom.ModArmorItem;
import net.parcival.wardium.item.tool.ModAxeItem;
import net.parcival.wardium.item.tool.ModHoeItem;
import net.parcival.wardium.item.tool.ModPickaxeItem;
import net.parcival.wardium.item.tool.ModShovelItem;

public class ModItems {

    //public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings().group(Wardium.WARDIUM_GROUP).maxCount(1)));
    public static final Item WARDIUM = registerItem("wardium", new Item(new FabricItemSettings().group(Wardium.WARDIUM_GROUP).maxCount(64)));

    public static final Item WARDIUM_HELMET = registerItem("wardium_helmet", new ModArmorItem(ModArmorMaterials.WARDIUM, EquipmentSlot.HEAD, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_CHESTPLATE = registerItem("wardium_chestplate", new ModArmorItem(ModArmorMaterials.WARDIUM, EquipmentSlot.CHEST, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_LEGGINGS = registerItem("wardium_leggings", new ModArmorItem(ModArmorMaterials.WARDIUM, EquipmentSlot.LEGS, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_BOOTS = registerItem("wardium_boots", new ModArmorItem(ModArmorMaterials.WARDIUM, EquipmentSlot.FEET, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));

    public static final Item WARDIUM_SWORD = registerItem("wardium_sword", new SwordItem(ModToolMaterials.WARDIUM, 5, -2F, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_AXE = registerItem("wardium_axe", new ModAxeItem(ModToolMaterials.WARDIUM, 6F, -2.8F, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_PICKAXE = registerItem("wardium_pickaxe", new ModPickaxeItem(ModToolMaterials.WARDIUM, 2, -2.8F, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_SHOVEL = registerItem("wardium_shovel", new ModShovelItem(ModToolMaterials.WARDIUM, 1, -2.8F, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));
    public static final Item WARDIUM_HOE = registerItem("wardium_hoe", new ModHoeItem(ModToolMaterials.WARDIUM, -3, 0.3F, new FabricItemSettings().group(Wardium.WARDIUM_GROUP)));



    public static void registerModItems() {}

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Wardium.MOD_ID, name), item);
    }
}
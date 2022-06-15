package net.parcival.wardium.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.parcival.wardium.item.ModArmorMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;
                if(hasFullSuitOfArmor(player)) {
                    if (hasCorrectArmorOn(player)) {
                        player.getSculkShriekerWarningManager().setWarningLevel(0);
                        if (player.hasStatusEffect(StatusEffect.byRawId(33))) {
                            player.removeStatusEffect(StatusEffect.byRawId(33));
                        }
                    }
                }


            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }
    private boolean hasCorrectArmorOn(PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        ArmorMaterial material = ModArmorMaterials.WARDIUM;

        return helmet.getMaterial() == material && chestplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Wearing a full set of").styled((style -> {return style.withColor(Formatting.GRAY);})));
        tooltip.add(Text.literal("this armor makes you").styled((style -> {return style.withColor(Formatting.GRAY);})));
        tooltip.add(Text.literal("immune to the Darkness").styled((style -> {return style.withColor(Formatting.GRAY);})));
        tooltip.add(Text.literal(" effect and sculk sensors.").styled((style -> {return style.withColor(Formatting.GRAY);})));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

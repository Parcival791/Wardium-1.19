package net.parcival.wardium.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }



    /*@Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if (stack.getHolder().isPlayer()) {
            stack.getTooltip((PlayerEntity)stack.getHolder(), context).add(Text.literal("Hi"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }*/

}

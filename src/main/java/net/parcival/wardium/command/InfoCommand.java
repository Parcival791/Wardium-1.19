package net.parcival.wardium.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

public class InfoCommand {
    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        PlayerEntity player = (PlayerEntity)source.getPlayer();
        source.sendFeedback(Text.literal("-----------------------").styled((style -> {return style.withColor(Formatting.DARK_GRAY);})).append(Text.literal("Wardium").styled((style -> {return style.withColor(TextColor.parse("#1a3cc7"));})).append(Text.literal("-----------------------").styled((style -> {return style.withColor(Formatting.DARK_GRAY);})))), false);
        source.sendFeedback(Text.literal("This Mod adds dropps to the Warden, from which you can craft Wardium Armor and Tools. "), false);
        return 1;
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("wardium").executes(InfoCommand::run));
    }
}
/*




 */
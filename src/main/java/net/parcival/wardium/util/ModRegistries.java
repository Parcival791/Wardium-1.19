package net.parcival.wardium.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.parcival.wardium.command.InfoCommand;

public class ModRegistries {
    public static void registerModStuff() {
        registerCommands();
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(InfoCommand::register);
    }
}

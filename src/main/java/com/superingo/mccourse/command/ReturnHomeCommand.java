package com.superingo.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.superingo.mccourse.MCCourseMod;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        // /home return
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes((command) -> {
            return returnHome(command.getSource());
        })));
    }

    private int returnHome(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasHomePos = player.getPersistentData().getIntArray(MCCourseMod.MOD_ID + "homepos").length != 0;

        if(hasHomePos) {
            int[] playerPos = player.getPersistentData().getIntArray(MCCourseMod.MOD_ID + "homepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);

            source.sendSuccess(new TextComponent("Player returned Home!"), true);
            return 1;
        } else {
            source.sendFailure(new TextComponent("No Home Position has been set!"));
            return -1;
        }
    }
}
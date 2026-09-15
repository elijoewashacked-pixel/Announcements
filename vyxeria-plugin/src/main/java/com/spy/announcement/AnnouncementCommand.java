package com.spy.announcement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnouncementCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + label + " <message>");
            return true;
        }

        String message = String.join(" ", args);
        String coloredMessage = ChatColor.translateAlternateColorCodes('&', message);

        for (Player player : Bukkit.getOnlinePlayers()) {
            String title = gradient("Vyxeria SMP", 0x9B30FF, 0x000000);
            player.sendTitle(title, coloredMessage, 10, 70, 20);
        }

        sender.sendMessage(ChatColor.GREEN + "Announcement sent to all players!");
        return true;
    }

    private String gradient(String text, int startRgb, int endRgb) {
        StringBuilder result = new StringBuilder();
        int length = text.length();

        int startR = (startRgb >> 16) & 0xFF;
        int startG = (startRgb >> 8) & 0xFF;
        int startB = startRgb & 0xFF;
        int endR = (endRgb >> 16) & 0xFF;
        int endG = (endRgb >> 8) & 0xFF;
        int endB = endRgb & 0xFF;

        for (int i = 0; i < length; i++) {
            float ratio = length == 1 ? 0 : (float) i / (length - 1);
            int r = (int) (startR + (endR - startR) * ratio);
            int g = (int) (startG + (endG - startG) * ratio);
            int b = (int) (startB + (endB - startB) * ratio);
            String hex = String.format("#%02X%02X%02X", r, g, b);
            result.append(ChatColor.of(hex)).append(ChatColor.BOLD).append(text.charAt(i));
        }

        return result.toString();
    }
}

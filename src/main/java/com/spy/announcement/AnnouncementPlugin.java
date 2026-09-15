package com.spy.announcement;

import org.bukkit.plugin.java.JavaPlugin;

public class AnnouncementPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Announcement plugin enabled!");
        getCommand("announcements").setExecutor(new AnnouncementCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Announcement plugin disabled!");
    }
}

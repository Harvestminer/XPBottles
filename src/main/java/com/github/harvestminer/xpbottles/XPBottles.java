package com.github.harvestminer.xpbottles;

import org.bukkit.plugin.java.JavaPlugin;

public final class XPBottles extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);
    }

    @Override
    public void onDisable() {
    }
}

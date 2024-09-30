package com.github.h3nriquel1ma.progressPulsePluginMain;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.DatabaseInitializer;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.CommandsStaticRegister;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.EventsRegister;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.VirtualSingleThread;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.VirtualThreadTask;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProgressPulsePlugin extends JavaPlugin {

    private final ConnectionManager databaseManagement = DatabaseManagement.getInstance(this);
    private LogUtil<String> loggerPlugin;

    @Override
    public void onEnable() {
        VirtualThreadManager virtualSingleThread = new VirtualSingleThread();
        VirtualTaskManager virtualThreadTask = new VirtualThreadTask();

        loggerPlugin = new LoggerPlugin(this);

        loggerPlugin.printInfo("ProgressPulse has been enabled!");

        DatabaseInitializer.initialize(this, virtualSingleThread, virtualThreadTask);
        EventsRegister.register(this, virtualSingleThread, virtualThreadTask);
        CommandsStaticRegister.register(this);
    }

    @Override
    public void onDisable() {
        databaseManagement.disconnect();

        loggerPlugin.printInfo("ProgressPulse has been disabled!");
    }
}

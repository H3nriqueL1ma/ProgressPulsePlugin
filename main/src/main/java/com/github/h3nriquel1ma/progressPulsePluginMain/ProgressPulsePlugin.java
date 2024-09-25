package com.github.h3nriquel1ma.progressPulsePluginMain;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.ConnectionManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadPoolManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.SpacingUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Commands.SkillsXpListCommand;
import com.github.h3nriquel1ma.progressPulsePluginModule.Events.*;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.DatabaseManagement;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerTableCreator;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.RegisterCommands;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.RegisterListeners;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.VirtualThreadPool;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads.VirtualThreadTask;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.SpacingChatText;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;

public final class ProgressPulsePlugin extends JavaPlugin {

    private ConnectionManager databaseManagement;
    private LogUtil<String> loggerPlugin;

    @Override
    public void onEnable() {
        VirtualThreadPoolManager virtualThreadPool = new VirtualThreadPool();
        CreationManager databasePlayerTableCreator = new DatabasePlayerTableCreator(this);
        VirtualTaskManager virtualThreadTask = new VirtualThreadTask();
        Register registerListeners = new RegisterListeners(this);
        Register registerCommands = new RegisterCommands(this);
        SpacingUtil spacingChatText = new SpacingChatText();
        loggerPlugin = new LoggerPlugin(this);
        databaseManagement = new DatabaseManagement(this);

        loggerPlugin.printInfo("ProgressPulse has been enabled!");

        databaseManagement.connect();

        ExecutorService newExecutor = virtualThreadPool.newExecutor(2);
        virtualThreadTask.execute(databasePlayerTableCreator::create, newExecutor);

        registerListeners.register(new JoinEventListener(this, virtualThreadPool, virtualThreadTask),
                                    new CombatEventListener(this),
                                    new ConstructionEventListener(this),
                                    new FishingEventListener(this),
                                    new MiningEventListener(this),
                                    new ResourceCollectionEventListener(this));

        registerCommands.register(
                "skillsXP",
                new SkillsXpListCommand(this, spacingChatText)
        );
    }

    @Override
    public void onDisable() {
        databaseManagement.disconnect();

        loggerPlugin.printInfo("ProgressPulse has been disabled!");
    }
}

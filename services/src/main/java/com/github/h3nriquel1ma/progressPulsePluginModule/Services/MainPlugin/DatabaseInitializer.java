package com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database.CreationManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables.DatabasePlayerTableCreator;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

public class DatabaseInitializer {

    public static void initialize(Plugin plugin, VirtualThreadManager virtualSingleThread, VirtualTaskManager virtualThreadTask) {
        CreationManager databasePlayerTableCreator = new DatabasePlayerTableCreator(plugin);
        ExecutorService singleExecutor = virtualSingleThread.newSingleExecutor();

        virtualThreadTask.execute(databasePlayerTableCreator::create, singleExecutor);

        singleExecutor.shutdown();
    }
}

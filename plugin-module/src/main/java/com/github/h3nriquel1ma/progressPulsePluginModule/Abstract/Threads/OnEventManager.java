package com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.LogUtil;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils.LoggerPlugin;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;

public abstract class OnEventManager {

    private final VirtualThreadManager singleThread;
    private final VirtualTaskManager threadTask;
    private final LogUtil<String> loggerPlugin;

    protected OnEventManager(Plugin plugin, VirtualThreadManager singleThread, VirtualTaskManager threadTask) {
        this.singleThread = singleThread;
        this.threadTask = threadTask;
        this.loggerPlugin = new LoggerPlugin(plugin);
    }

    protected void onEvent(String taskName, Runnable task) {
        ExecutorService singleExecutor = singleThread.newSingleExecutor();

        threadTask.execute(task, singleExecutor).whenComplete((result, throwable) -> {
            singleExecutor.shutdown();

            if (throwable != null) {
                loggerPlugin.printErr("Error executing " + taskName + " task: " + throwable.getMessage());
            }
        });
    }
}

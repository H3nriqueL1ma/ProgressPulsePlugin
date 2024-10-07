package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads;

import com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Threads.OnEventManager;

public class OnEventInstance {
    private final OnEventManager onEventManager;

    public OnEventInstance(OnEventManager onEventManager) {
        this.onEventManager = onEventManager;
    }

    public void executeOnEventInstance(String taskName, Runnable task) {
        onEventManager.onEvent(taskName, task);
    }
}

package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class VirtualThreadTask implements VirtualTaskManager {

    @Override
    public CompletableFuture<Void> execute(Runnable classExecuted, ExecutorService executor) {
        return CompletableFuture.runAsync(classExecuted, executor);
    }
}

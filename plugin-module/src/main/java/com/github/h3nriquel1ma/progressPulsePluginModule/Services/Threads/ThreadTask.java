package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.TaskManager;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class ThreadTask<T> implements TaskManager<T> {

    @Override
    public void execute(Supplier<T> classExecuted, ExecutorService executor) {
        CompletableFuture.supplyAsync(classExecuted, executor);
    }
}

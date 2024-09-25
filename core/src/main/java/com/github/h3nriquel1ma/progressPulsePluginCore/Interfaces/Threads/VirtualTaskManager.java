package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public interface VirtualTaskManager {
    CompletableFuture<Void> execute(Runnable classExecuted, ExecutorService executor);
}

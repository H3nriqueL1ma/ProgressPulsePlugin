package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;

import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public interface TaskManager<T> {
    void execute(Supplier<T> classExecuted, ExecutorService executor);
}

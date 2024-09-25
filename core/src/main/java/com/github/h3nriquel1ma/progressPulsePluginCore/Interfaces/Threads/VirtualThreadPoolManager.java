package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;

import java.util.concurrent.ExecutorService;

public interface VirtualThreadPoolManager {
    ExecutorService newExecutor(int threadsNumber);
}

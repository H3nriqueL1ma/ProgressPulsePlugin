package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;

import java.util.concurrent.ExecutorService;

public interface ThreadPoolManager {
    ExecutorService newExecutor(int threadsNumber);
}

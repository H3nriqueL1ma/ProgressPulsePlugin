package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.ThreadPoolManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements ThreadPoolManager {

    @Override
    public ExecutorService newExecutor(int threadsNumber) {
        return Executors.newFixedThreadPool(threadsNumber);
    }
}

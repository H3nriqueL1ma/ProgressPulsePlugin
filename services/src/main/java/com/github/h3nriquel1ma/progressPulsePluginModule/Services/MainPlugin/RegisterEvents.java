package com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin.Register;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualTaskManager;
import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;
import com.github.h3nriquel1ma.progressPulsePluginModule.Events.*;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin.SubRegisters.RegisterListeners;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Verification.OreOrBlockVerifier;
import com.github.h3nriquel1ma.progressPulsePluginModule.Services.Verification.PickaxeVerifier;
import org.bukkit.plugin.Plugin;

public class RegisterEvents {

    public static void register(Plugin plugin, VirtualThreadManager virtualSingleThread, VirtualTaskManager virtualThreadTask) {
        Register registerListeners = new RegisterListeners(plugin);

        registerListeners.register(new JoinEventListener(plugin, virtualSingleThread, virtualThreadTask),
                new CombatEventListener(plugin, virtualSingleThread, virtualThreadTask),
                new ConstructionEventListener(plugin, virtualSingleThread, virtualThreadTask),
                new FishingEventListener(plugin, virtualSingleThread, virtualThreadTask),
                new MiningEventListener(plugin, virtualSingleThread, virtualThreadTask, new PickaxeVerifier(), new OreOrBlockVerifier()),
                new ResourceCollectionEventListener(plugin, virtualSingleThread, virtualThreadTask));
    }
}

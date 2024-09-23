open module progress.pulse.plugin.module {
    requires core;
    requires org.bukkit;
    requires java.sql;
    requires net.kyori.adventure;
    requires org.jetbrains.annotations;

    exports com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.MainPlugin;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Events;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Commands;
}
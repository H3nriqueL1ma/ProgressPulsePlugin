open module progress.pulse.plugin.module {
    requires core;
    requires org.bukkit;
    requires java.sql;

    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services to main;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Abstract.Database to main;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database to main;
    exports com.github.h3nriquel1ma.progressPulsePluginModule.Services.Database.Tables to main;
}
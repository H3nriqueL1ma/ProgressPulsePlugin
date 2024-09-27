open module core {
    requires jdk.compiler;
    requires org.bukkit;
    requires com.zaxxer.hikari;
    requires java.sql;

    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database;
    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils;
    exports com.github.h3nriquel1ma.progressPulsePluginCore.Models;
    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.MainPlugin;
    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;
}
open module core {
    requires java.sql;
    requires jdk.compiler;

    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Database to progress.pulse.plugin.module, main;
    exports com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils to progress.pulse.plugin.module;
}
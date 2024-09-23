package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.SpacingUtil;

public class SpacingChatText implements SpacingUtil {

    @Override
    public String addSpacing(String text, int maxPadding) {
        int space = maxPadding - text.length();

        return text + " ".repeat(Math.max(0, space));
    }
}

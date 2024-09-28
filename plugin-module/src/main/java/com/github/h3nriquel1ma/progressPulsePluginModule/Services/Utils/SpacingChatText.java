package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Utils;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Utils.SpacingUtil;

public class SpacingChatText implements SpacingUtil {

    @Override
    public String addSpacing(String text, int size) {
        String ret = text;

        if ( text != null ) {

            for (int i=0; i < text.length(); i++) {
                if ( text.charAt(i) == 'I' || text.charAt(i) == ' ') {
                    ret += " ";
                }
            }

            int lackSpaces = size - text.length();
            lackSpaces = (lackSpaces * 2);

            for (int i=0; i < lackSpaces; i++) {
                ret += " ";
            }
        }

        return (ret);
    }
}


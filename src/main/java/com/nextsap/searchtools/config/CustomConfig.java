package com.nextsap.searchtools.config;

import com.nextsap.searchtools.utils.Launcher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * An object class 'CustomConfig'
 */

@Getter
@Setter
@AllArgsConstructor
public class CustomConfig {

    private Launcher launcher;
    private boolean config;

    public CustomConfig() {
        this.launcher = null;
        this.config = false;
    }
}

package org.ashr.comediator.impl;

import org.ashr.comediator.api.Command;

public class LongCommand implements Command.OneWayCommand {

    public String word;

    public LongCommand(String word) {
        this.word = word;
    }
}

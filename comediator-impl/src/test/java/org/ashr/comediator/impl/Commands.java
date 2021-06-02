package org.ashr.comediator.impl;

import org.ashr.comediator.api.Command;
import org.ashr.comediator.api.CommandHandler;

public class Commands {

    public static class StringCommand implements Command<String> {
        public String name;
        public StringCommand(String name) {
            this.name = name;
        }
    }

    public static class IntegerCommand implements Command<Integer> {
        public Integer age;
        public IntegerCommand(Integer age) {
            this.age = age;
        }
    }

    public static class StringCommandHandler implements CommandHandler<String, StringCommand> {

        @Override
        public String handle(StringCommand command) {
            return "Hello: Rtfs " + command.name;
        }

    }

    public static class IntegerCommandHandler implements CommandHandler<Integer, IntegerCommand> {

        @Override
        public Integer handle(IntegerCommand command) {
            return command.age + 1000;
        }
    }

}

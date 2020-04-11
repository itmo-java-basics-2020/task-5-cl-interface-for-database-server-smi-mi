package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.error("Command text must not be null.");
        }
        String[] commandWithArgs = commandText.split(" ");
        String commandName = commandWithArgs[0];

        try {
            DatabaseCommands commandType = DatabaseCommands.valueOf(commandName);
            DatabaseCommand command = commandType.getCommand(env, commandWithArgs);
            return command.execute();
        } catch (IllegalArgumentException | DatabaseException exception) {
            return DatabaseCommandResult.error(exception.getMessage());
        }
    }
}

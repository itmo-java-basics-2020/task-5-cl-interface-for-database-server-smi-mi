package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.DatabaseDefault;

public class CreateDatabaseCommand implements DatabaseCommand {
    private final ExecutionEnvironment env;
    private final String databaseName;

    public CreateDatabaseCommand(ExecutionEnvironment env, String databaseName) {
        this.env = env;
        this.databaseName = databaseName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            return DatabaseCommandResult.error("Database " + databaseName + " already exists.");
        }
        env.addDatabase(new DatabaseDefault(databaseName));
        return DatabaseCommandResult.success("Database " + databaseName + " was created successfully.");
    }
}

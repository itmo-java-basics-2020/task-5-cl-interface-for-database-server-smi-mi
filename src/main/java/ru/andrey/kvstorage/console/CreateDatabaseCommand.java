package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.logic.DatabaseDefault;

public class CreateDatabaseCommand implements  DatabaseCommand {

    public CreateDatabaseCommand (ExecutionEnvironment env, String databaseName) {
        this.env = env;
        this.databaseName = databaseName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        env.addDatabase(new DatabaseDefault(databaseName));
        // TODO check and throw exception
        return DatabaseCommandResult.success(null);
    }

    private final ExecutionEnvironment env;
    private String databaseName;
}

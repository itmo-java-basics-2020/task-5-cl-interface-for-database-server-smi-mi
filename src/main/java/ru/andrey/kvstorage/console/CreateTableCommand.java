package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
    private final ExecutionEnvironment env;
    private final String databaseName;
    private final String tableName;

    public CreateTableCommand(ExecutionEnvironment env, String databaseName, String tableName) {
        this.env = env;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = env.getDatabase(databaseName);
        if (database.isEmpty()) {
            return DatabaseCommandResult.error("No database with name " + databaseName);
        }
        try {
            database.get().createTableIfNotExists(tableName);
        } catch (DatabaseException exception) {
            return DatabaseCommandResult.error(exception.getMessage());
        }
        return DatabaseCommandResult.success("Table " + tableName +
                " in database " + databaseName + " was created successfully.");
    }
}

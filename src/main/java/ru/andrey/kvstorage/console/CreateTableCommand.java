package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateTableCommand implements DatabaseCommand {

    public CreateTableCommand(ExecutionEnvironment env, String databaseName, String tableName) {
        this.env = env;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        // TODO check and throw exception
        Database database = env.getDatabase(databaseName).get();
        database.createTableIfNotExists(tableName);
        return DatabaseCommandResult.success(null);
    }

    private final ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
}

package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class ReadKeyCommand implements DatabaseCommand {

    public ReadKeyCommand(ExecutionEnvironment env, String databaseName, String tableName, String key) {
        this.env = env;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        // TODO check
        Database database = env.getDatabase(databaseName).get();
        String value = database.read(tableName, key);
        return DatabaseCommandResult.success(value);
    }

    private final ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;
}

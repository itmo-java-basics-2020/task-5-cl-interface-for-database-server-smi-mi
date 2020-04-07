package ru.andrey.kvstorage.console;

import jdk.jshell.EvalException;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class UpdateKeyCommand implements DatabaseCommand {

    public UpdateKeyCommand(ExecutionEnvironment env, String databaseName, String tableName, String key, String value) {
        this.env = env;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        // TODO check
        Database database = env.getDatabase(databaseName).get();
        database.write(tableName, key, value);
        return DatabaseCommandResult.success(null);
    }

    private final ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;
    private String value;
}

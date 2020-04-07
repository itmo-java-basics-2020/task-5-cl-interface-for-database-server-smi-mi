package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE {
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args == null || args.length < 2) {
                throw new IllegalArgumentException("At least two arguments required.");
            }
            return new CreateDatabaseCommand(env, args[1]);
        }
    },
    CREATE_TABLE {
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args == null || args.length < 3) {
                throw new IllegalArgumentException("At least three arguments required.");
            }
            return new CreateTableCommand(env, args[1], args[2]);
        }
    },
    UPDATE_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args == null || args.length < 5) {
                throw new IllegalArgumentException("At least five arguments required.");
            }
            return new UpdateKeyCommand(env, args[1], args[2], args[3], args[4]);
        }
    },
    READ_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args == null || args.length < 4) {
                throw new IllegalArgumentException("At least fore arguments required.");
            }
            return new ReadKeyCommand(env, args[1], args[2], args[3]);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String... args);
}

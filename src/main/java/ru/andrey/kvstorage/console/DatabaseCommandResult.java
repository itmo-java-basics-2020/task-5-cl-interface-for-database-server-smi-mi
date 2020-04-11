package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultDefault(DatabaseCommandStatus.SUCCESS, result, null);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultDefault(DatabaseCommandStatus.FAILED, null, message);
    }

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    class DatabaseCommandResultDefault implements DatabaseCommandResult {
        private final DatabaseCommandStatus status;
        private final String result;
        private final String message;

        private DatabaseCommandResultDefault(DatabaseCommandStatus status, String result, String message) {
            this.status = status;
            this.result = result;
            this.message = message;
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(this.result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return this.status;
        }

        @Override
        public boolean isSuccess() {
            return this.status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage() {
            return this.message;
        }
    }
}
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

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(this.result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return this.status;
        }

        @Override
        public boolean isSuccess(){
            return this.status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage(){
            return this.message;
        }

        private DatabaseCommandResultDefault(DatabaseCommandStatus status, String result, String message) {
            this.status = status;
            this.result = result;
            this.message = message;
        }

        private DatabaseCommandStatus status;
        private String result;
        private String message;
    }
}
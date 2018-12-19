package de.urr4.todomanager.exceptions;

public class TodoManagerException extends RuntimeException {

    private final TodoManagerExceptionType type;

    public TodoManagerException(TodoManagerExceptionType type) {
        this.type = type;
    }

    public TodoManagerExceptionType getType() {
        return type;
    }

}

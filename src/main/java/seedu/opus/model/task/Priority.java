package seedu.opus.model.task;

import seedu.opus.commons.exceptions.IllegalValueException;

/**
 * Represents a Task's priority in the task manager. Guarantees: immutable; is
 * valid as declared in {@link #isValidPriority(String)}
 */
public class Priority {

    public static enum Type {

        NONE,
        HIGH,
        MEDIUM,
        LOW;

        @Override
        public String toString() {
            switch(this) {
            case HIGH:
                return PRIORITY_HIGH;
            case MEDIUM:
                return PRIORITY_MEDIUM;
            case LOW:
                return PRIORITY_LOW;
            case NONE:
                return PRIORITY_NONE;
            default:
                throw new AssertionError();
            }
        }

    }

    public static final String MESSAGE_PRIORITY_CONSTRAINTS = "Task priority can only take specific string "
            + "values hi, mid, low, none.";
    public static final String PRIORITY_VALIDATION_REGEX = "[^\\s].*";
    public static final String PRIORITY_HIGH = "hi";
    public static final String PRIORITY_MEDIUM = "mid";
    public static final String PRIORITY_LOW = "low";
    public static final String PRIORITY_NONE = "none";

    private final Type value;

    /**
     * Validates given priority.
     *
     * @throws IllegalValueException
     *             if given priority is invalid.
     */
    public Priority(String priority) throws IllegalValueException {
        assert priority != null;
        String trimmedPriority = priority.trim();
        if (!isValidPriority(trimmedPriority)) {
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
        this.value = parseUserInputString(trimmedPriority);
    }

    public Priority(Priority.Type priority) {
        assert priority != null;
        this.value = priority;
    }

    /**
     * Initialise a Priority with Type value of Type.NONE
     */
    public Priority() {
        this.value = Type.NONE;
    }

    /**
     * parse a string priority into Priority.Type.
     *
     * @param priority
     * @return Priority.Type value
     * @throws IllegalValueException
     */
    public static Priority.Type parseUserInputString(String priority) throws IllegalValueException {
        assert priority != null;
        switch (priority.toLowerCase()) {
        case PRIORITY_HIGH:
            return Type.HIGH;
        case PRIORITY_MEDIUM:
            return Type.MEDIUM;
        case PRIORITY_LOW:
            return Type.LOW;
        case PRIORITY_NONE:
            return Type.NONE;
        default:
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
    }

    public static Priority.Type parseXmlString(String priority) throws IllegalValueException {
        assert priority != null;
        try {
            return Type.valueOf(priority);
        } catch (IllegalArgumentException e) {
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid input.
     */
    public static boolean isValidPriority(String test) {
        switch (test.toLowerCase()) {
        case PRIORITY_NONE:
            return true;
        case PRIORITY_HIGH:
            return true;
        case PRIORITY_MEDIUM:
            return true;
        case PRIORITY_LOW:
            return true;
        default:
            return false;
        }
    }

    /**
     * @return the current value of the priority
     */
    public Type getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Priority // instanceof handles nulls
                        && this.value.equals(((Priority) other).value)); // state
                                                                         // check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
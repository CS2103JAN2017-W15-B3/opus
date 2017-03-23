package seedu.opus.model.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.opus.commons.exceptions.IllegalValueException;
import seedu.opus.model.task.Priority.Type;

public class PriorityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void isValidPriority() {
        // invalid priorities
        assertFalse(Priority.isValidPriority("")); // empty string
        assertFalse(Priority.isValidPriority(" ")); // spaces only

        // valid priorities
        assertTrue(Priority.isValidPriority("none")); // no priority
        assertTrue(Priority.isValidPriority("hi")); // high priority
        assertTrue(Priority.isValidPriority("mid")); // medium priority
        assertTrue(Priority.isValidPriority("low")); // low priority
    }

    @Test (expected = IllegalValueException.class)
    public void initialisePriorityWithInvalidArgs() throws IllegalValueException {
        @SuppressWarnings("unused")
        Priority invalidPriority = new Priority("HIGH");
    }

    @Test
    public void parseValidUserInputString() throws IllegalValueException {
        assertEquals(Priority.parseUserInputString("none"), Priority.Type.NONE);
        assertEquals(Priority.parseUserInputString("hi"), Priority.Type.HIGH);
        assertEquals(Priority.parseUserInputString("mid"), Priority.Type.MEDIUM);
        assertEquals(Priority.parseUserInputString("low"), Priority.Type.LOW);
    }

    @Test (expected = IllegalValueException.class)
    public void parseInvalidUserInputString() throws IllegalValueException {
        Priority.parseUserInputString("1a$");
    }

    @Test
    public void toUserInputString() {
        assertEquals(Type.NONE.toString(), Priority.PRIORITY_NONE);
        assertEquals(Type.HIGH.toString(), Priority.PRIORITY_HIGH);
        assertEquals(Type.MEDIUM.toString(), Priority.PRIORITY_MEDIUM);
        assertEquals(Type.LOW.toString(), Priority.PRIORITY_LOW);
    }

    @Test
    public void parseValidXmlString() throws IllegalValueException {
        assertEquals(Priority.parseXmlString("NONE"), Priority.Type.NONE);
        assertEquals(Priority.parseXmlString("HIGH"), Priority.Type.HIGH);
        assertEquals(Priority.parseXmlString("MEDIUM"), Priority.Type.MEDIUM);
        assertEquals(Priority.parseXmlString("LOW"), Priority.Type.LOW);
    }

    @Test (expected = IllegalValueException.class)
    public void pareseInvalidXmlString() throws IllegalValueException {
        Priority.parseXmlString("NON");
    }
}
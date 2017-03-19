package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.Command;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws IllegalValueException 
     */
    public Command parse(String args) throws IllegalValueException {
        ArgumentTokenizer argsTokenizer =
                new ArgumentTokenizer(PREFIX_PRIORITY, PREFIX_STATUS, PREFIX_NOTE, PREFIX_DEADLINE, PREFIX_TAG);
        argsTokenizer.tokenize(args);
        return new AddCommand(
                argsTokenizer.getPreamble().get(),
                ParserUtil.toValue(argsTokenizer.getValue(PREFIX_PRIORITY), "priority"),
                ParserUtil.toValue(argsTokenizer.getValue(PREFIX_STATUS), "status"),
                ParserUtil.toValue(argsTokenizer.getValue(PREFIX_NOTE), "note"),
                ParserUtil.toValue(argsTokenizer.getValue(PREFIX_DEADLINE), "deadline"),
                ParserUtil.toSet(argsTokenizer.getAllValues(PREFIX_TAG))
            );
    }

}

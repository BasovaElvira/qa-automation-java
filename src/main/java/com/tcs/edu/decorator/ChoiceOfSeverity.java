package com.tcs.edu.decorator;

/**
 * This class chooses severity
 *
 * @author Basova Elvira
 */

public interface ChoiceOfSeverity {

    /**
     * @param severity is Enum
     * @return add severity to message
     */
    static String chooseSeverity(Severity severity) {

        String severityForPrint;

        switch (severity) {
            case MINOR:
                severityForPrint = "()"; break;
            case REGULAR:
                severityForPrint = "(!)"; break;
            case MAJOR:
                severityForPrint = "(!!!)"; break;
            default:
                severityForPrint = "WARN: the value doesn't exist";
        }
        return severityForPrint;
    }
}

package com.tcs.edu.decorator;

import com.tcs.edu.enums.*;
import com.tcs.edu.interfaces.*;

/**
 * This class chooses severity
 *
 * @author Basova Elvira
 */

public class ChoiceOfSeverityImpl implements ChoiceOfSeverity {

    /**
     * @param severity is Enum
     * @return add severity to message
     */
    @Override
    public String chooseSeverity(Severity severity) {

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

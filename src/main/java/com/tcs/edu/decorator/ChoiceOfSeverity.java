package com.tcs.edu.decorator;

/**
 * This class chooses severity
 *
 * @author Basova Elvira
 */

public class ChoiceOfSeverity {

    public static String chooseSeverity(Severity severity) {

        switch (severity) {
            case MINOR: return "()";
            case REGULAR: return "(!)";
            case MAJOR: return "(!!!)";
            default: return "WARN: the value doesn't exist";
        }
    }
}

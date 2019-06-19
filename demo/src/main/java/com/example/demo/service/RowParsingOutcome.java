package com.example.demo.service;

import java.util.StringJoiner;

public class RowParsingOutcome {

    private final String errorMessage;
    private final boolean success;

    public RowParsingOutcome(String errorMessage, boolean success) {

        this.errorMessage = errorMessage;
        this.success = success;
    }

    public static RowParsingOutcome success() {
        return new RowParsingOutcome("", true);
    }

    public static RowParsingOutcome failure(String error) {
        return new RowParsingOutcome(error, false);
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RowParsingOutcome.class.getSimpleName() + "[", "]")
                .add("errorMessage='" + errorMessage + "'")
                .add("success=" + success)
                .toString();
    }
}

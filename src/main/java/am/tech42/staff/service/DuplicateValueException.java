package am.tech42.staff.service;

import org.postgresql.util.PSQLException;

public class DuplicateValueException extends Exception {
    private String constraint;

    public DuplicateValueException(PSQLException e) {
        this.constraint = e.getServerErrorMessage().getConstraint();
    }

    public String getConstraint() {
        return constraint;
    }
}

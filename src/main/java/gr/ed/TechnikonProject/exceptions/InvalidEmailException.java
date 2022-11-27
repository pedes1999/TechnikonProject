package gr.ed.TechnikonProject.exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(String errorMsg) {
        super(errorMsg);
    }
}

package gr.ed.TechnikonProject.exceptions;

public class UnauthorizedException extends Exception {

    public UnauthorizedException(String errorMsg) {
        super(errorMsg);
    }
}

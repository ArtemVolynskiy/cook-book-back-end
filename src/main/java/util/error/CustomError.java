package util.error;

public class CustomError {
    private String errorMessage;

    public CustomError(){}

    public CustomError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCustomError(){
        return this.errorMessage;
    }
}

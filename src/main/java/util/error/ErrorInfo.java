package util.error;

public class ErrorInfo {

    public ErrorInfo(CharSequence url, Throwable ex) {
        this(url, ex.getClass().getSimpleName(), ex.getLocalizedMessage());
    }

    private ErrorInfo(CharSequence requestURL, String cause, String... details) {
        String url = requestURL.toString();
    }
}

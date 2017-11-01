package util.exception;


public class ExceptionUtil {
    private ExceptionUtil(){}

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, String name) {
        return checkNotFound(object, "id=" + name);
    }

    private static <T> T checkNotFound(T object, String message) {
        checkNotFound(object != null, message);
        return object;
    }

    private static void checkNotFound(boolean found, String message) {
        if (!found) {
            throw new NotFoundException("Not found entiti with " + message);
        }
    }
}

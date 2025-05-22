public class Operation {
    String type;
    String key;
    String oldValue;
    boolean hadKey;

    Operation(String type, String key, String oldValue, boolean hadKey) {
        this.type = type;
        this.key = key;
        this.oldValue = oldValue;
        this.hadKey = hadKey;
    }
}

import java.util.*;

public class KeyValueStore {
    private Map<String, String> store;
    private Stack<Operation> transactionLog;
    private boolean inTransaction;

    public KeyValueStore() {
        this.store = new HashMap<>();
        this.transactionLog = new Stack<>();
        this.inTransaction = false;
    }

    public void set(String key, String value) {
        if (inTransaction) {
            boolean hadKey = store.containsKey(key);
            String oldValue = hadKey ? store.get(key) : null;
            transactionLog.push(new Operation("SET", key, oldValue, hadKey));
        }
        store.put(key, value);
    }

    public String get(String key) {
        return store.getOrDefault(key, "NULL");
    }

    public void delete(String key) {
        if (inTransaction && store.containsKey(key)) {
            transactionLog.push(new Operation("DELETE", key, store.get(key), true));
        }
        store.remove(key);
    }

    public void begin() {
        if (!inTransaction) {
            transactionLog.clear();
            inTransaction = true;
        }
    }

    public void commit() {
        if (!inTransaction) {
            System.out.println("NO TRANSACTION");
            return;
        }
        transactionLog.clear();
        inTransaction = false;
    }

    public void rollback() {
        if (!inTransaction) {
            System.out.println("NO TRANSACTION");
            return;
        }

        while (!transactionLog.isEmpty()) {
            Operation op = transactionLog.pop();
            if (op.type.equals("SET")) {
                if (op.hadKey) {
                    store.put(op.key, op.oldValue);
                } else {
                    store.remove(op.key);
                }
            } else if (op.type.equals("DELETE")) {
                store.put(op.key, op.oldValue);
            }
        }

        inTransaction = false;
    }

    public void reset() {
        store.clear();
        transactionLog.clear();
        inTransaction = false;
    }
}

package io.sentry.jvmti;

public class LocalsCache {
    private static ThreadLocal<Frame[]> result = new ThreadLocal<>();

    public static void setResult(Frame[] r) {
        result.set(r);
    }

    public static Frame[] getResult() {
        return result.get();
    }
}

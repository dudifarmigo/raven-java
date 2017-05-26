package io.sentry.jvmti;

public class LocalsCache {
    private static ThreadLocal<Frame[]> result = new ThreadLocal<>();

    public static void setCache(Frame[] frames) {
        result.set(frames);
    }

    public static Frame[] getCache() {
        return result.get();
    }
}

package io.sentry.jvmti;

public final class LocalsCache {
    private static ThreadLocal<Frame[]> result = new ThreadLocal<>();

    private LocalsCache() {

    }

    public static void setCache(Frame[] frames) {
        result.set(frames);
    }

    public static Frame[] getCache() {
        return result.get();
    }
}

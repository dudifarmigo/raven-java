package io.sentry.jvmti;

public final class LocalsCache {
    private static ThreadLocal<Frame[]> result = new ThreadLocal<Frame[]>() {
        @Override
        protected Frame[] initialValue() {
            return new Frame[0];
        }
    };

    private LocalsCache() {

    }

    public static void setCache(Frame[] frames) {
        result.set(frames);
    }

    public static Frame[] getCache() {
        return result.get();
    }
}

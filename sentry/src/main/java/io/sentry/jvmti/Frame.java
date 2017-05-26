package io.sentry.jvmti;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public final class Frame {
    private final Method method;
    private final Object localThis;
    private final LocalVariable[] locals;
    private final int location;
    private final int linenumber;
    private final Map<String, LocalVariable> namedLocals = new HashMap<>();

    public Frame(Method method, Object localThis, LocalVariable[] locals, int pos, int lineno) {
        this.method = method;
        this.localThis = localThis;
        this.locals = locals;
        this.location = pos;
        this.linenumber = lineno;
        if (locals != null) {
            for (LocalVariable local : locals) {
                if (local != null) {
                    namedLocals.put(local.name, local);
                }
            }
        }
    }

    public Method getMethod() {
        return method;
    }

    public Object getLocalThis() {
        return localThis;
    }

    public LocalVariable[] getLocals() {
        return locals;
    }

    public int getLocation() {
        return location;
    }

    public int getLinenumber() {
        return linenumber;
    }

    public Map<String, LocalVariable> getNamedLocals() {
        return namedLocals;
    }

    public static final class LocalVariable {
        final boolean live;
        final String name;
        final String signature;
        final String genericSignature;
        final Object value;

        private LocalVariable(String name, String signature, String genericSignature, Object value) {
            this.live = true;
            this.name = name;
            this.signature = signature;
            this.genericSignature = genericSignature;
            this.value = value;
        }

        private LocalVariable(String name, String signature, String genericSignature) {
            this.live = false;
            this.name = name;
            this.signature = signature;
            this.genericSignature = genericSignature;
            this.value = null;
        }

        public boolean isLive() {
            return live;
        }

        public String getName() {
            return name;
        }

        public String getSignature() {
            return signature;
        }

        public String getGenericSignature() {
            return genericSignature;
        }

        public Object getValue() {
            return value;
        }
    }
}

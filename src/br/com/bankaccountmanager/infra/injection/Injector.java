package br.com.bankaccountmanager.infra.injection;

import java.util.HashMap;
import java.util.Map;

public class Injector {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void inject(Class<T> key, T instance) {
        instances.put(key, instance);
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> identity) throws Exception {
        T instance = (T) instances.get(identity);
        if (instance == null)
            throw new Exception("No binds found for: ".concat(identity.getSimpleName()));
        return instance;
    }

    public void clear() {
        instances.clear();
    }
}

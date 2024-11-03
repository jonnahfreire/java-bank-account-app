package br.com.bankaccountmanager.infra.injection;

import java.util.HashMap;
import java.util.Map;

public class Injector {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void inject(Class<T> key, T instance) throws Exception {
        if (key == null)
            throw new Exception("Cannot create bind for Key of Null value");
        if (instance == null)
            throw new Exception("Cannot create bind for Instance of Null value");

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

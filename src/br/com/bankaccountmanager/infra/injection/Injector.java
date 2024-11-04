package br.com.bankaccountmanager.infra.injection;

import br.com.bankaccountmanager.infra.injection.exception.InjectionInstanceException;
import br.com.bankaccountmanager.infra.injection.exception.InjectionRegisterException;
import java.util.HashMap;
import java.util.Map;

public class Injector {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void inject(Class<T> key, T instance) throws InjectionRegisterException {
        if (key == null)
            throw new InjectionRegisterException("Cannot create bind for Key of Null value");
        if (instance == null)
            throw new InjectionRegisterException("Cannot create bind for Instance of Null value");
        if (instances.get(key) != null)
            throw new InjectionRegisterException("Instance for " + key.getSimpleName() + " already exists");

        instances.put(key, instance);
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> identity) throws InjectionInstanceException {
        T instance = (T) instances.get(identity);
        if (instance == null)
            throw new InjectionInstanceException("No binds found for: ".concat(identity.getSimpleName()));
        return instance;
    }

    public void clear() {
        instances.clear();
    }
}

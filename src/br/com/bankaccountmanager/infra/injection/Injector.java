package br.com.bankaccountmanager.infra.injection;
import java.util.HashMap;

public class Injector<T> {
    private HashMap<String, T> instances = new HashMap<>();

    void inject(T instance) {
        this.instances.put(instance.getClass().getSimpleName(), instance);
    }

    public T getInstance(String identity) {
        return this.instances.get(identity);
    }

    void clear() {
        this.instances.clear();
    }
}

package br.com.bankaccountmanager.domain.shared.utils;

public class Return<T> {
    private final T value;

    public Return(T value) {
        this.value = value;
    }

    public T Value() {
        return value;
    }

    public static <T> Return<T> of(T value) {
        return new Return<>(value);
    }

    public static Return<Void> Empty() {
        return new Return<>(null);
    }
}

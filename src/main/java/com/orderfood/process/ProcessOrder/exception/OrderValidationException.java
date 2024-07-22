package com.orderfood.process.ProcessOrder.exception;

public class OrderValidationException extends Throwable {
    public OrderValidationException(String invalidOrder) {
        super(invalidOrder);
    }
    @Override
    public String toString() {
        return "OrderValidationException: " + super.toString();
    }
}

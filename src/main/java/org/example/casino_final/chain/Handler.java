package org.example.casino_final.chain;

public abstract class Handler {
    protected Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public abstract boolean handle(int result);
}

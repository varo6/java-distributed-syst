package main.network;

import java.io.Serializable;

public class CloseMessage extends Header implements Serializable {

    protected static final int LENGTH = 1;

    public CloseMessage() {
        super(LENGTH);
    }
}

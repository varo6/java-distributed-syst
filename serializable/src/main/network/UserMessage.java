package main.network;

import java.net.*;

public class UserMessage extends Header {

    String name = "";
    int dni = 0;
    protected static final int LENGTH = 2;

    //UserMessage servirá como login, conteniendo nombre e identificador de usuario
    public UserMessage(String n, int d) {
        super(LENGTH);
        this.type = LOGIN;
        this.name = n;
        this.dni = d;
    }
}

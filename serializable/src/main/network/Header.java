package main.network;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class Header implements Serializable {

    // Podría declarar con mayusculas que valor int tiene cada tipo: HEADER=0;
    protected int length = 0;
    protected int headerLength = 8;
    protected int type = 0;
    public static final int TEXT = 1;
    public static final int LOGIN = 2;
    public static final int CLOSE = 3;

    public Header(int l) {
        this.length = l;
    }

    public int getType() {
        return type;
    }

    public int getHeaderLength() {
        return headerLength;
    }

    public byte[] pack() {
        byte[] bytes = new byte[headerLength];
        ByteBuffer bb = ByteBuffer.allocate(headerLength);
        bb.putInt(type);
        bb.putInt(length);
        bb.flip();
        bb.get(bytes, 0, bytes.length);
        return bytes;
    }

    public void unpack(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        this.type = bb.getInt();
        this.length = bb.getInt();
    }
}

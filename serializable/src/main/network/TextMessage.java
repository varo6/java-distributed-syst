package main.network;

import java.io.Serializable;

public class TextMessage extends Header implements Serializable {

    protected String text = "";
    protected int dni = 0;
    protected static final int LENGTH = 2;
    //En este caso, el dni servirá A QUIEN quiera enviar el mensaje.
    public TextMessage(String text, int dni) {
        super(LENGTH);
        this.type = TEXT;
        this.dni = dni;
        this.text = text;
    }

    public byte[] pack() {
        int tmLength = (text.length() * 2) + 4;
        byte[] bytes = new byte[headerLength + tmLength];
        ByteBuffer bb = ByteBuffer.allocate(headerLength + tmLength);
        bb.putInt(type);
        bb.putInt(length);
        bb.putInt(dni);

        byte[] textBytes = text.getBytes();
        for(byte b : textBytes) {
            bb.put(b);
        }
        bb.flip();
        bb.get(bytes, 0, bytes.length);
        return bytes;
    }

    public void unpack(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        int tmLength = (bytes.length - headerLength - 4)/2;
        this.type = bb.getInt();
        this.length = bb.getInt();

        this.dni = bb.getInt();
        //Recorremos un bucle de chars y se lo añadimos a un array de chars:
        Char[] arrtext = new Char[];
        for (int i=0; i++; i<bytes.length){
            this.text += (char) bb.get();

        }
      }
      public void unpack(byte[] bytes) {
          ByteBuffer bb = ByteBuffer.wrap(bytes);
          this.type = bb.getInt();
          this.length = bb.getInt();
          this.dni = bb.getInt();

          byte[] textBytes = new byte[bytes.length - headerLength - 12];
          bb.get(textBytes);
          this.text = new String(textBytes);
      }
    public String getText() {
        return this.text;
    }

    public int getDni() {
        return this.dni;
    }
}

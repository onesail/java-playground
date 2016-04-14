package main;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class PrintAllCharacters {

    public static void main(String[] args) {

        Charset charset = Charset.forName("ISO-8859-1"); // ISO-8859-15, Cp1252

        System.out.print(charset.name() + "\n     ");
        for (byte x = 0; x < 16; x++) {
            System.out.print(String.format("%02X ", x));
        }
        System.out.println("\n   +-------------------------------------------------");

        for (byte y = 0; y < 16; y++) {
            System.out.print(String.format("%02X | ", y << 4));
            for (byte x = 0; x < 16; x++) {
                byte b = (byte) (y << 4 | x);
                Character c = decodeByte(charset, b);
                boolean show = Character.isISOControl(c);
                System.out.print(String.format(" %c ", show ? ' ' : c));
            }
            System.out.println();
        }
    }

    public static Character decodeByte(Charset charset, byte b) {
        return charset.decode(ByteBuffer.wrap(new byte[]{b})).get(0);
    }

}

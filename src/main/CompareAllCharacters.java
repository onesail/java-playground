package main;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class CompareAllCharacters {

    // found 40 codes in windows-1252 that where decoded to different characters in ISO-8859-15

    public static void main(String[] args) {
        compareCharsets("Cp1252", "ISO-8859-15");
    }

    public static void compareCharsets(String charset1, String charset2) {
        compareCharsets(Charset.forName(charset1), Charset.forName(charset2));
    }
    public static void compareCharsets(Charset charset1, Charset charset2) {
        int numberOfunmatchedCharacters = 0;
        for (int i = 0; i < 0x100; i++) { // cant iterate over bytes, because 0x100 ist not a byte
            byte b = (byte) i;
            char char1 = decodeByte(charset1, b);
            char char2 = decodeByte(charset2, b);
            if (!Character.isISOControl(char1)) {
                boolean charactersMatch = char1 == char2;
                if (!charactersMatch) {
                    numberOfunmatchedCharacters++;
                    System.out.println(String.format("%02X %c %c", b, char1, char2));
                }
            }
        }
        System.out.println(String.format("found %d codes in %s that were decoded to different characters in %s", numberOfunmatchedCharacters, charset1, charset2));
    }

    public static Character decodeByte(Charset charset, byte b) {
        return charset.decode(ByteBuffer.wrap(new byte[]{b})).get(0);
    }

}

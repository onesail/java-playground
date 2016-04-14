package main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CompareStrings {

    public static void main(String[] args) {

        String text = "€´ Jährlich ";
        System.out.println(String.format("%d characters: %s", text.length(), text));

        System.out.println("compare encoding for Cp-1252 and ISO-8859-15:");
        byte[] codes1 = text.getBytes(Charset.forName("Cp1252"));
        byte[] codes2 = text.getBytes(Charset.forName("ISO-8859-15"));

        assert codes1.length == codes2.length : "strings must have same length";

        for (int i = 0; i < codes1.length; i++) {
            byte code1 = codes1[i];
            byte code2 = codes2[i];
            boolean sameCode = code1 == code2;

            if(!sameCode) {
                System.out.println(String.format("%3d: '%c' %02X != %02X", i, text.charAt(i), code1, code2));
            }
        }

    }

}

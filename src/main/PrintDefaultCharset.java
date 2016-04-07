package main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class PrintDefaultCharset {

    public static void main(String[] args) {

        System.out.println("Default Charset            : " + Charset.defaultCharset());
        System.out.println("Default Charset Name       : " + Charset.defaultCharset().name());
        System.out.println("Default Charset Displayname: " + Charset.defaultCharset().displayName());

        //System.setProperty("file.encoding", "Latin-1");
        System.out.println("Property file.encoding     : " + System.getProperty("file.encoding"));

        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        System.out.println("OutputStreamWriter Encoding: " + writer.getEncoding());

        System.out.println();

        String text = "Jährlich";
        System.out.println(String.format("%-15s (%2d)  %s", "Text", text.length(), text ));
        printBytes(text, Charset.forName("Cp1252"));
        printBytes(text, Charset.forName("ISO-8859-1"));
        printBytes(text, Charset.forName("US-ASCII"));
        printBytes(text, Charset.forName("UTF-8"));
        printBytes(text, Charset.forName("UTF-16"));
    }

    public static void printBytes(String text, Charset charset) {
        byte[] encodedString = text.getBytes(charset);
        System.out.print(String.format("%-15s (%2d)  ", charset.name(), encodedString.length));
        for(byte c : encodedString) {
            System.out.print(String.format("%02X ", c));
        }
        System.out.println();
    }

}

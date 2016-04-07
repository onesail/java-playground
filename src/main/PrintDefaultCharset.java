package main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class PrintDefaultCharset {

    public static void main(String[] args) {
        System.out.println("Default Charset            : " + Charset.defaultCharset());
        System.out.println("Default Charset Name       : " + Charset.defaultCharset().name());
        System.out.println("Default Charset Displayname: " + Charset.defaultCharset().displayName());

        //System.setProperty("file.encoding", "Latin-1");
        System.out.println("Property file.encoding     : " + System.getProperty("file.encoding"));

        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        System.out.println("OutputStreamWriter Encoding: " + writer.getEncoding());
    }

}

package main;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class PrintAllCharsets {

    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for(String key : charsets.keySet()) {
            Charset cs = charsets.get(key);
            System.out.print(String.format("%-20s: ", cs.name()));
            for(String alias : cs.aliases()) {
                System.out.print(alias + " ");
            }
            System.out.println();
        }
    }

}

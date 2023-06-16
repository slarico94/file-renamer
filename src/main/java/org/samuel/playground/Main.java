package org.samuel.playground;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author Samuel Larico
 */
public class Main {

    public static void main(String[] args) {

        //Receive argument: 0 - path

        //String path = args[0];
        String path = "/home/samuel/Documents/oracle-bk";
        Scanner sc = new Scanner(System.in);
        //Validate path
        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist");
            return;
        }

        Optional<File[]> filesOptional = Optional.ofNullable(directory.listFiles()) ;

        if (filesOptional.isEmpty()) {
            return;
        }
        File[] files = filesOptional.get();
        System.out.printf("%nTotal files founded: %d%n", files.length);
        //Extract list of file and show to user
        int counter = 0;
        for (File file : files) {
            long lastModified = file.lastModified();
            Instant instant = Instant.ofEpochMilli(lastModified);
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            System.out.printf("%d. %s %s%n", (counter + 1), file.getName(), localDateTime.format(formatter));
            counter++;
        }

        //Ask for rename method
        //1. Rename single file
        //1. Replace text, ask for text and new text
        //2. Suffix/prefix (timestamp, numeric order
        //3. Regular expressions
        //4. convert to upper or lower case
        //5. Truncation, specify a maximum length for the file and truncate, save the extension




        //2. Rename all files


        System.out.printf("%");

        //rename files base on the method


        //show results to users

    }
}
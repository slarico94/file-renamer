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

/**
 * @author Samuel Larico
 */
public class Main {

    public static void main(String[] args) {

        //Receive argument: 0 - path

        //String path = args[0];
        String path = "/home/samuel/Documents/oracle-bk";

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
        System.out.printf("Files founded:%n");
        //Extract list of file and show to user
        for (File file : files) {
            long lastModified = file.lastModified();
            Instant instant = Instant.ofEpochMilli(lastModified);
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            System.out.printf("File: %s %s%n", file.getName(), localDateTime.format(formatter));
        }
        System.out.printf("%nTotal: %d%n", files.length);


        //Ask for rename method


        //rename files base on the method


        //show results to users

    }
}
package com.bridgeLabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperations {

    public static void main(String[] args) throws IOException {

        File fileName = new File("gopal5.txt");
        System.out.println(fileName.exists());
        fileName.createNewFile();
        System.out.println("Check file is exists or not :- " + fileName.exists());

        fileName.delete();
        System.out.println("Delete File and Check File Not Exist :-" + fileName.exists());

        fileName.mkdir();
        System.out.println("Check file directory :- " +fileName.exists());

//        Files.createDirectory("gopalIO");
//        Files.exists("gopalIO");

        File fileName2 = new File("abc.txt");
        fileName2.createNewFile();
        System.out.println("creating a empty file :- "+fileName2.exists());

       // Files.list(Path.of("gopal-IO")).filter(Files::isRegularFile).forEach(System.out::println);
       // Files.newDirectoryStream("gopalIO").forEach(System.out::println);

    }
}

package com.bridgeLabz;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static java.nio.file.Files.deleteIfExists;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckThenConfirm() throws Exception{

        //Check file Exists

        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        // Delete file and Check file not exists
        Path playPath = Paths.get(HOME +"/"+PLAY_WITH_NIO);
      //  if (Files.exists(playPath)) fileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        //Create Directory
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        //Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assert.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            Assert.assertTrue(Files.exists(tempFile));
        });

        //List files, Directories, as well as Files with Extension
        Files.list(playPath).filter(Files::isRegularFile)
                .forEach(System.out::println);
        Files.newDirectoryStream(playPath)
                .forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
                path.toString().startsWith("temp"))
                .forEach(System.out::println);

    }
}

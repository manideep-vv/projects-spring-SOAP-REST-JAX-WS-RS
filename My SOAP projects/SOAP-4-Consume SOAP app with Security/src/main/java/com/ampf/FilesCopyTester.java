package com.ampf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyTester {
    public static void main(String[] args) throws IOException {
        Path sourcePath = Paths.get("C:\\Users\\Manideep\\Downloads\\Lalitha Lavanya R.pdf");
        Path destPath = Paths.get("C:\\Users\\Manideep\\Downloads\\Radhika-v1.pdf");

        InputStream fileInputStream = new FileInputStream("C:\\Users\\Manideep\\Downloads\\Lalitha Lavanya R.pdf");
        Files.copy(fileInputStream, destPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("files has been copied");
    }

}

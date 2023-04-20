package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileData fileData = new FileData();
        fileData.load("hw5.csv");

        System.out.println(Arrays.toString(fileData.getHeader()));
        System.out.println(Arrays.deepToString(fileData.getData()));

        fileData.save("hw5-new.csv");
    }
}

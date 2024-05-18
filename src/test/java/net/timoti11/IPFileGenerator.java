package net.timoti11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IPFileGenerator {
    private static final Random random = new Random();
    final public static int IP_AMMOUNT = 100000000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Path file = Paths.get("ip_addresses_TEST.txt");

        var ipAddresses = IntStream.range(0, IP_AMMOUNT)
                .mapToObj(i -> generateRandomIPAddress())
                .collect(Collectors.toList());

        try {
            Files.write(file, ipAddresses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] mainArgs = {"ip_addresses_TEST.txt"};
        long startTimeMain = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() - startTime;
        Main.main(mainArgs);
        System.out.println("Time for generate: " + endTime + "ms");
        System.out.println("Time for find unique addresses: " + (System.currentTimeMillis() - startTimeMain) + "ms");
    }

    private static String generateRandomIPAddress() {
        return random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256);
    }
}
package net.timoti11;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static net.timoti11.Converter.getUniqueAddresses;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Detected " + args.length + " arguments, but 1 argument was expected");
            LOGGER.severe("args.length != 1");
            return;
        }
        final File file = new File(args[0]);

        try (var lines = Files.lines(file.toPath(), StandardCharsets.US_ASCII)) {
            long startTime = System.currentTimeMillis();
            long countUniqueAddresses = UniqueAddressesCounter(lines);
            LOGGER.info("Process time: " + (System.currentTimeMillis() - startTime));
            LOGGER.info("Found " + countUniqueAddresses + " unique IP addresses!");
        } catch (IOException e) {
            LOGGER.severe("File " + file.toPath() + " not found.");
        }
    }

    public static long UniqueAddressesCounter(Stream<String> ipStream) {
        ipStream.forEach(ip -> {
            new Converter().convertToLong(ip);
        });
        return getUniqueAddresses();
    }
}
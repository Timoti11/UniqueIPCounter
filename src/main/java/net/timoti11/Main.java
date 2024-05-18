package net.timoti11;

import net.timoti11.util.Converter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static net.timoti11.util.BitHandler.getUniqueAddresses;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.severe("Detected " + args.length + " arguments, but 1 argument was expected");
            return;
        }
        final File file = new File(args[0]);

        try (Stream<String> lines = Files.lines(file.toPath(), StandardCharsets.US_ASCII)) {
            long startTime = System.currentTimeMillis();
            long countUniqueAddresses = countUniqueAddresses(lines);
            LOGGER.info("Process time: " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Found " + countUniqueAddresses + " unique IP addresses!");
        } catch (IOException e) {
            LOGGER.severe("File " + file.toPath() + " not found.");
        }
    }

    public static long countUniqueAddresses(Stream<String> ipStream) {
        Converter converter = new Converter();
        ipStream.forEach(converter::convertToLong);
        return getUniqueAddresses();
    }
}
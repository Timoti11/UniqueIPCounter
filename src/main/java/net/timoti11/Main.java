package net.timoti11;

import net.timoti11.util.IpProcessor;
import net.timoti11.util.IpAddressTracker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * Run the program with the command line or powershell command
     * java -jar UniqueIPCounter.jar <filename>
     * where <filename> - full or relative path to the txt file.
     *
     * Full README about build and run the program: https://github.com/Timoti11/UniqueIPCounter/blob/main/README.MD
     */

    public static void main(String[] args) {
        //Check for illegal arguments
        if (args.length != 1) {
            LOGGER.severe("Detected " + args.length + " arguments, but 1 argument was expected");
            return;
        }
        //Getting a file from a command line argument
        final File file = new File(args[0]);

        try (Stream<String> lines = Files.lines(file.toPath(), StandardCharsets.US_ASCII)) {
            //Write the program start time
            long startTime = System.currentTimeMillis();

            //Creating objects for working with strings
            IpAddressTracker ipAddressTracker = new IpAddressTracker();
            IpProcessor ipProcessor = new IpProcessor(ipAddressTracker);

            //Processing IP addresses from a file
            processIpAddresses(lines, ipProcessor);

            //Getting the final count of unique addressess
            long countUniqueAddresses = ipAddressTracker.getCountUniqueAddresses();

            //Info output after the search is completed
            LOGGER.info("Process time: " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Found " + countUniqueAddresses + " unique IP addresses!");
        } catch (IOException e) {
            LOGGER.severe("File " + file.toPath() + " not found.");
        }
    }

    public static void processIpAddresses(Stream<String> ipStream, IpProcessor ipProcessor) {
        //convertAndHandleIp for each String from Stream
        ipStream.forEach(ipProcessor::convertAndHandleIp);
    }
}
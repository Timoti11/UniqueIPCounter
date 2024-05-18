package net.timoti11.util;

public class Converter {
    private static final BitHandler bitHandler = new BitHandler();

    public void convertToLong(String ipAddress) {
        long ipConverted = IPConverter.convertIpToLong(ipAddress);
        bitHandler.handleByteShift(ipConverted);
    }
}
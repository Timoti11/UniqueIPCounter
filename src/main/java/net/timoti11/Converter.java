package net.timoti11;

public class Converter {
    private static final long[] STORAGE = new long[1 << 26];
    private static long addressCounter = 0;

    public void convertToLong(String ipAddress) {
        long ipConverted = convertIpToLong(ipAddress);
        handleByteShift(ipConverted);
    }

    private long convertIpToLong(String ipAddress) {
        long result = 0L;
        int shift = 24;

        for (String part : ipAddress.split("\\.")) {
            long partLong = Long.parseLong(part);
            result |= (partLong << shift);
            shift-=8;
        }

        return result;
    }

    private static void handleByteShift(long ipConverted) {
        addressCounter += setBit(ipConverted) ? 0 : 1;
    }

    private static boolean setBit(long ipConverted) {
        long storageIndex = ipConverted >> 6;
        int bitIndex = (int) (ipConverted % 64);

        long currentStorage = STORAGE[(int) storageIndex];

        long safeValue = STORAGE[(int) storageIndex];
        long bitMask = 1L << bitIndex;

        boolean isBitExit = (currentStorage & bitMask) != 0;

        STORAGE[(int) storageIndex] = currentStorage | bitMask;

        return isBitExit;
    }

    public static long getUniqueAddresses() {
        return addressCounter;
    }
}
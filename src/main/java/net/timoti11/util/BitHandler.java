package net.timoti11.util;

public class BitHandler {
    private static final long[] STORAGE = new long[1 << 26];
    private static long addressCounter = 0;

    public void handleByteShift(long ipConverted) {
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

package net.timoti11.util;

public class IpAddressTracker {
    private final long[] storage;
    private long addressCounter;

    public IpAddressTracker() {
        this.storage = new long[1 << 26];
        this.addressCounter = 0;
    }

    public void checkAndIncrementCounter(long ipConverted) {
        if (!setBit(ipConverted)) addressCounter++;
    }

    private boolean setBit(long ipConverted) {
        long storageIndex = ipConverted >> 6;
        int bitIndex = (int) (ipConverted % 64);

        long currentStorage = storage[(int) storageIndex];

        long bitMask = 1L << bitIndex;

        boolean isBitSet = (currentStorage & bitMask) != 0;

        storage[(int) storageIndex] = currentStorage | bitMask;

        return isBitSet;
    }

    public long getCountUniqueAddresses() {
        return addressCounter;
    }
}
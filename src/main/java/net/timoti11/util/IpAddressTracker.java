package net.timoti11.util;

public class IpAddressTracker {
    private final long[] storage;
    private long uniqueAddressCounter;

    /**
     * The IpAddressTracker class is responsible for tracking unique IP addresses.
     * It uses a bitwise array to efficiently store and check the uniqueness of IP addresses.
     * The class provides methods to check and increment the counter for unique IP addresses
     * and to retrieve the total count of unique IP addresses encountered.
     */

    public IpAddressTracker() {
        this.storage = new long[1 << 26];
        this.uniqueAddressCounter = 0;
    }

    /**
     * Checks if the given IP address has been encountered before and increments
     * the counter for unique IP addresses if it has not.
     *
     * @param ipConverted The IP address converted to a long value.
     *
     * I also like the option where there is no condition,
     * just a return value like int 0 or 1 that is ALWAYS added,
     * but there's the question of how long it would take to do the folding each time
     *         uniqueAddressCounter += setBit(ipConverted);
     */
    public void checkAndIncrementCounter(long ipConverted) {
        if (!setBit(ipConverted)) uniqueAddressCounter++;
    }

    /**
     * Sets the bit corresponding to the given IP address in the storage array.
     * This method is used to determine if the IP address is unique and to mark it as encountered.
     *
     * @param ipConverted The IP address converted to a long value.
     * @return true if the bit was already set (indicating a duplicate IP address), false otherwise.
     */
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
        return uniqueAddressCounter;
    }
}
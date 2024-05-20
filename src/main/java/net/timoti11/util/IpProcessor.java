package net.timoti11.util;

/**
 * General class for process each IP from stream
 * Performs 2 tasks:
 * 1. Converts String IP address to long representation of it.
 * 2. Checks the address for duplicate and increments or not the counter of unique IP addresses.
 */
public class IpProcessor {
    private final IpAddressTracker ipAddressTracker;

    public IpProcessor(IpAddressTracker ipAddressTracker) {
        this.ipAddressTracker = ipAddressTracker;
    }

    public void convertAndHandleIp(String ipAddress) {
        //Take the long representation of address
        long ipConverted = IPConverter.convertIpToLong(ipAddress);
        //Checks for duplicate and increment the counter if need it
        ipAddressTracker.checkAndIncrementCounter(ipConverted);
    }
}
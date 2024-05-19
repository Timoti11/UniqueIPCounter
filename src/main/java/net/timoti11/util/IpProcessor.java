package net.timoti11.util;

public class IpProcessor {
    private final IpAddressTracker ipAddressTracker;

    public IpProcessor(IpAddressTracker ipAddressTracker) {
        this.ipAddressTracker = ipAddressTracker;
    }

    public void convertAndHandleIp(String ipAddress) {
        long ipConverted = IPConverter.convertIpToLong(ipAddress);
        ipAddressTracker.checkAndIncrementCounter(ipConverted);
    }
}
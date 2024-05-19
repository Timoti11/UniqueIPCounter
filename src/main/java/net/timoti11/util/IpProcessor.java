package net.timoti11.util;

public class IpProcessor {
    private static final IpAddressTracker ipAddressTracker = new IpAddressTracker();

    public void convertAndHandleIp(String ipAddress) {
        long ipConverted = IPConverter.convertIpToLong(ipAddress);
        ipAddressTracker.checkAndIncrementCounter(ipConverted);
    }
}
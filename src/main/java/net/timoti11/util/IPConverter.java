package net.timoti11.util;

class IPConverter {
    public static long convertIpToLong(String ipAddress) {
        long result = 0L;
        int shift = 24;

        for (String part : ipAddress.split("\\.")) {
            long partLong = Long.parseLong(part);
            result |= (partLong << shift);
            shift -= 8;
        }

        return result;
    }
}
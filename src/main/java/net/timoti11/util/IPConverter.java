package net.timoti11.util;

class IPConverter {
    public static long convertIpToLong(String ipAddress) {
        long result = 0L;
        long partLong = 0L;
        int shift = 24;

        for (int i = 0; i < ipAddress.length(); i++) {
            char c = ipAddress.charAt(i);
            if (c == '.') {
                result |= (partLong << shift);
                shift -= 8;
                partLong = 0;
            } else {
                partLong = (partLong * 10) + (c - '0');
            }
        }
        result |= partLong;

        return result;
    }
}
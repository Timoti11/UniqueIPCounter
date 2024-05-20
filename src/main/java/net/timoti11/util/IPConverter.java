package net.timoti11.util;

/**
 * The IPConverter class provides a utility method to convert an IP address from its string representation
 * to a long representation.
 */
class IPConverter {
    public static long convertIpToLong(String ipAddress) {
        long result = 0L;
        long partLong = 0L;
        int shift = 24;

        for (int i = 0; i < ipAddress.length(); i++) {
            char c = ipAddress.charAt(i);
            // If the character is a dot, shift the part to its correct position and reset partLong for new segment of address
            if (c == '.') {
                result |= (partLong << shift);
                shift -= 8;
                partLong = 0;
            } else {
                // Accumulate the numerical value of the current segment of address
                // Logic example:
                // 123 = (((1 * 10) + 2) * 10) + 3
                partLong = (partLong * 10) + (c - '0');
            }
        }
        result |= partLong;

        return result;
    }
}
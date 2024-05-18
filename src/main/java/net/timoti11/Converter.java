package net.timoti11;

public class Converter {
    private static final long[] storage = new long[1 << 26];
    private static long addressCounter = 0;

    public void convertToLong(String value) {
        var parts = value.split("\\.");

        long resultLong = 0;

        for (int i = 0; i < parts.length; i++) {
            long ip = Long.parseLong(parts[i]);
            resultLong += ip << (8 * (3 - i));
        }
//        System.out.println("IP: " + value);
//        System.out.println("resultLong: " + resultLong);
        byteShift(resultLong);
        System.out.println();
    }

    public static void byteShift(long input) {
//        System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576 + " MB");
//        System.out.println(counter + "/" + "1000000");
        if (!setBit(input)) {
            addressCounter++;
        }
    }

    public static boolean setBit(long input) {
        long indexStorage = input / 64;
        int indexStorageInt = (int) indexStorage;

        long indexStorageBit = input - indexStorage * 64;
        int indexStorageBitInt = (int) indexStorageBit;

        long currentStorage = storage[indexStorageInt];

//        System.out.println("Storage: " + indexStorage);
//        System.out.println("Bit: " + indexStorageBit);
//        System.out.println("Initial storage(int)[" + indexStorageInt + "]: " + storage[indexStorageInt]);
//        System.out.println("Initial storage(decimal)[" + indexStorageInt + "]: " + Long.toBinaryString(currentStorage));
//        System.out.println("indexStorageBitInt: " + indexStorageBitInt);

        if ((currentStorage & (1L << indexStorageBitInt)) != 0) {
//            System.out.println("Updated storage[" + indexStorageInt + "]: " + Long.toBinaryString(storage[indexStorageInt]));
//            System.out.println("SKIP!");
            return true;
        } else {
            storage[indexStorageInt] = currentStorage | (1L << indexStorageBitInt);
//            System.out.println("Updated storage[" + indexStorageInt + "]: " + Long.toBinaryString(storage[indexStorageInt]));
//            System.out.println("NEW VALUE!");
            return false;
        }
    }

    public static long getUniqueAddresses() {
        return addressCounter;
    }
}
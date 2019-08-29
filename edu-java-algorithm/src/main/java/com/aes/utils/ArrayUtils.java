package com.aes.utils;

/**
 * Created by zing on 17-5-10.
 */
public class ArrayUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static byte[] subarray(byte[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        } else {
            if (startIndexInclusive < 0) {
                startIndexInclusive = 0;
            }

            if (endIndexExclusive > array.length) {
                endIndexExclusive = array.length;
            }

            int newSize = endIndexExclusive - startIndexInclusive;
            if (newSize <= 0) {
                return EMPTY_BYTE_ARRAY;
            } else {
                byte[] subarray = new byte[newSize];
                System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
                return subarray;
            }
        }
    }

    public static <T> int indexOf(T[] array, T t) {
        if (array == null || t == null) {
            return -1;
        }
        int i = 0, arrayLen = array.length;
        for (; i < arrayLen; i++) {
            if (array[i].equals(t)) {
                break;
            }
        }
        return i;
    }

    public static int indexOf(byte[] array, byte target) {
        if (array == null) {
            return -1;
        }
        int i = 0, arrayLen = array.length;
        for (; i < arrayLen; i++) {
            if (array[i] == target) {
                break;
            }
        }
        return i;
    }

}

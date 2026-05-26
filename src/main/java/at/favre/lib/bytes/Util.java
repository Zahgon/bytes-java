/*
 * Copyright 2017 Patrick Favre-Bulle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package at.favre.lib.bytes;

import java.io.*;
import java.nio.*;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

/**
 * Common Util methods to convert or modify byte arrays
 */
final class Util {

    /**
     * Util methods related general purpose byte utility.
     */
    static final class Byte {

        private Byte() {
        }

        /**
         * Returns the values from each provided byteArray combined into a single byteArray.
         * For example, {@code append(new byte[] {a, b}, new byte[] {}, new
         * byte[] {c}} returns the byteArray {@code {a, b, c}}.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param arrays zero or more {@code byte} arrays
         * @return a single byteArray containing all the values from the source arrays, in
         * order
         */
        static byte[] concat(byte[]... arrays) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Combines a single argument with a vararg to a single array
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param firstByte first arg
         * @param moreBytes varargs
         * @return array containing all args
         */
        static byte[] concatVararg(byte firstByte, byte[] moreBytes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Returns the start position of the first occurrence of the specified {@code
         * target} within {@code array}, or {@code -1} if there is no such occurrence.
         * <p>
         * <p>More formally, returns the lowest index {@code i} such that {@code
         * java.util.Arrays.copyOfRange(array, i, i + target.length)} contains exactly
         * the same elements as {@code target}.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n*m)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array  the array to search for the sequence {@code target}
         * @param target the array to search for as a sub-sequence of {@code array}
         */
        static int indexOf(byte[] array, byte[] target, int start, int end) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Returns the index of the last appearance of the value {@code target} in
         * {@code array}.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array  an array of {@code byte} values, possibly empty
         * @param target a primitive {@code byte} value
         * @return the greatest index {@code i} for which {@code array[i] == target},
         * or {@code -1} if no such index exists.
         */
        static int lastIndexOf(byte[] array, byte target, int start, int end) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Counts the occurrence of target in the subject array
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array  to count in
         * @param target to count
         * @return number of times target is in subject
         */
        static int countByte(byte[] array, byte target) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Counts the times given pattern (i.e. an array) can be found in given array
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n*m)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array   to count in
         * @param pattern to match in array
         * @return number of times pattern is in subject
         */
        static int countByteArray(byte[] array, byte[] pattern) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Simple Durstenfeld shuffle.
         * This will shuffle given array and will not make a copy, so beware.
         * <p>
         * See: <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm">Yates_shuffle</a>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>true</code></li>
         * </ul>
         * </p>
         *
         * @param array  to shuffle
         * @param random used to derive entropy - use {@link java.security.SecureRandom} instance if you want this to be secure
         */
        static void shuffle(byte[] array, Random random) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reverses the elements of {@code array} between {@code fromIndex} inclusive and {@code toIndex}
         * exclusive. This is equivalent to {@code
         * Collections.reverse(Bytes.asList(array).subList(fromIndex, toIndex))}, but is likely to be more
         * efficient.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>true</code></li>
         * </ul>
         * </p>
         *
         * @throws IndexOutOfBoundsException if {@code fromIndex < 0}, {@code toIndex > array.length}, or
         *                                   {@code toIndex > fromIndex}
         */
        static void reverse(byte[] array, int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Light shift of whole byte array by shiftBitCount bits.
         * This method will alter the input byte array.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>true</code></li>
         * </ul>
         * </p>
         *
         * @param byteArray     to shift
         * @param shiftBitCount how many bits to shift
         * @param byteOrder     endianness of given byte array
         * @return shifted byte array
         */
        static byte[] shiftLeft(byte[] byteArray, int shiftBitCount, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Unsigned/logical right shift of whole byte array by shiftBitCount bits.
         * This method will alter the input byte array.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>true</code></li>
         * </ul>
         * </p>
         *
         * @param byteArray     to shift
         * @param shiftBitCount how many bits to shift
         * @param byteOrder     endianness of given byte array
         * @return shifted byte array
         */
        static byte[] shiftRight(byte[] byteArray, int shiftBitCount, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * See https://codahale.com/a-lesson-in-timing-attacks/
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array        to check for equals
         * @param anotherArray to check against array
         * @return if both arrays have the same length and same length for every index
         */
        static boolean constantTimeEquals(byte[] array, byte[] anotherArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Calculates the entropy factor of a byte array.
         * <p>
         * This implementation will not create a copy of the internal array and will only internally initialize
         * an int array with 256 elements as temporary buffer.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array to calculate the entropy from
         * @return entropy factor, higher means higher entropy
         */
        static double entropy(byte[] array) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Util method related converting byte arrays to other types.
     */
    static final class Converter {

        private Converter() {
        }

        /**
         * Copies a collection of {@code Byte} instances into a new array of
         * primitive {@code byte} values.
         * <p>
         * <p>Elements are copied from the argument collection as if by {@code
         * collection.toArray()}.  Calling this method is as thread-safe as calling
         * that method.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param collection a collection of {@code Byte} objects
         * @return an array containing the same values as {@code collection}, in the
         * same order, converted to primitives
         * @throws NullPointerException if {@code collection} or any of its elements
         *                              is null
         */
        static byte[] toArray(Collection<java.lang.Byte> collection) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts this primitive array to a boxed object array.
         * Will create a new array and not reuse the array reference.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array to convert
         * @return new array
         */
        static java.lang.Byte[] toBoxedArray(byte[] array) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts given array to list of boxed bytes. Will create a new list
         * and not reuse the array reference.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param array to convert
         * @return list with same length and content as array
         */
        static List<java.lang.Byte> toList(byte[] array) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts this object array to a primitives type array.
         * Will create a new array and not reuse the array reference.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param objectArray to convert
         * @return new array
         */
        static byte[] toPrimitiveArray(java.lang.Byte[] objectArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a byte array from given short array.
         * The resulting byte array will have length shortArray * 2.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param shortArray to convert
         * @return resulting byte array
         */
        static byte[] toByteArray(short[] shortArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a byte array from given int array.
         * The resulting byte array will have length intArray * 4.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param intArray to convert
         * @return resulting byte array
         */
        static byte[] toByteArray(int[] intArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a byte array from given float array.
         * The resulting byte array will have length floatArray * 4.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param floatArray to convert
         * @return resulting byte array
         */
        static byte[] toByteArray(float[] floatArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a byte array from given long array.
         * The resulting byte array will have length longArray * 8
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param longArray to convert
         * @return resulting byte array
         */
        static byte[] toByteArray(long[] longArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a byte array from given double array.
         * The resulting byte array will have length doubleArray * 8.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param doubleArray to convert
         * @return resulting byte array
         */
        static byte[] toByteArray(double[] doubleArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts a char array to a byte array with given charset and range
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param charArray to get the byte array from
         * @param charset   charset to be used to decode the char array
         * @param offset    to start reading the char array from (must be smaller than length and gt 0)
         * @param length    from offset (must be between 0 and charArray.length())
         * @return byte array of encoded chars
         */
        static byte[] charToByteArray(char[] charArray, Charset charset, int offset, int length) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Convert given byte array in given encoding to char array
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     as data source
         * @param charset   of the byte array
         * @param byteOrder the order of the bytes array
         * @return char array
         */
        static char[] byteToCharArray(byte[] bytes, Charset charset, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts the byte array to an int array. This will spread 4 bytes into a single int:
         *
         * <pre>
         *     [b1, b2, b3, b4] = [int1]
         * </pre>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     to convert to int array, must be % 4 == 0 to work correctly
         * @param byteOrder of the byte array
         * @return int array
         */
        static int[] toIntArray(byte[] bytes, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts the byte array to a long array. This will spread 8 bytes into a single long:
         *
         * <pre>
         *     [b1, b2, b3, b4, b5, b6, b7, b8] = [long1]
         * </pre>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     to convert to long array, must be % 8 == 0 to work correctly
         * @param byteOrder of the byte array
         * @return long array
         */
        static long[] toLongArray(byte[] bytes, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts the byte array to a float array. This will spread 4 bytes into a single float:
         *
         * <pre>
         *     [b1, b2, b3, b4] = [float1]
         * </pre>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     to convert to float array, must be % 4 == 0 to work correctly
         * @param byteOrder of the byte array
         * @return float array
         */
        static float[] toFloatArray(byte[] bytes, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts the byte array to a double array. This will spread 8 bytes into a single double:
         *
         * <pre>
         *     [b1, b2, b3, b4, b5, b6, b7, b8] = [double1]
         * </pre>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     to convert to double array, must be % 8 == 0 to work correctly
         * @param byteOrder of the byte array
         * @return double array
         */
        static double[] toDoubleArray(byte[] bytes, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Converts the byte array to a short array. This will spread 2 bytes into a single short:
         *
         * <pre>
         *     [b1, b2] = [short1]
         * </pre>
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(n)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes     to convert to short array, must be % 2 == 0 to work correctly
         * @param byteOrder of the byte array
         * @return short array
         */
        static short[] toShortArray(byte[] bytes, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Convert UUID to a newly generated 16 byte long array representation. Puts the 8 byte most significant bits and
         * 8 byte least-significant bits into a byte array.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(1)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param uuid to convert to array
         * @return buffer containing the 16 bytes
         */
        static ByteBuffer toBytesFromUUID(UUID uuid) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Util method related to Object class methods.
     */
    static final class Obj {

        private Obj() {
        }

        /**
         * Equals method comparing 2 byte arrays.
         * This utilizes a quick return of the array differs on any given property so not suitable
         * for security relevant checks. See  {@link Util.Byte#constantTimeEquals(byte[], byte[])}
         * for that.
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param obj          subject a
         * @param anotherArray subject b to compare to a
         * @return if a.len == b.len and for every 0..len a[i] == b[i]
         */
        static boolean equals(byte[] obj, java.lang.Byte[] anotherArray) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Hashcode implementation for a byte array and given byte order
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(n)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param byteArray to calculate hashCode of
         * @param byteOrder to calculate hashCode of
         * @return hashCode
         */
        static int hashCode(byte[] byteArray, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shows the length and a preview of max 8 bytes of the given byte
         *
         * <p>
         * <strong>Analysis</strong>
         * <ul>
         * <li>Time Complexity: <code>O(1)</code></li>
         * <li>Space Complexity: <code>O(1)</code></li>
         * <li>Alters Parameters: <code>false</code></li>
         * </ul>
         * </p>
         *
         * @param bytes to convert to string
         * @return string representation
         */
        static String toString(Bytes bytes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Util method related check and validate byte arrays.
     */
    static final class Validation {

        private Validation() {
        }

        /**
         * Check if a length of a primitive (e.g. int = 4 byte) fits in given length from given start index.
         * Throws exception with descriptive exception message.
         *
         * @param length          of the whole array
         * @param index           to start from array length
         * @param primitiveLength length of the primitive type to check
         * @param type            for easier debugging the human-readable type of the checked primitive
         *                        to put in exception message
         * @throws IndexOutOfBoundsException if index + primitiveLength > length
         */
        static void checkIndexBounds(int length, int index, int primitiveLength, String type) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Check if given length is an expected length.
         * Throws exception with descriptive exception message.
         *
         * @param length         of the whole array
         * @param expectedLength how length is expected
         * @param type           for easier debugging the human-readable type of the checked primitive
         *                       to put in exception message
         * @throws IllegalArgumentException if length != expectedLength
         */
        static void checkExactLength(int length, int expectedLength, String type) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Checks if given length is divisible by mod factor (with zero rest).
         * This can be used to check of a byte array can be converted to an e.g. int array which is
         * multiples of 4.
         *
         * @param length       of the byte array
         * @param modFactor    to divide the length
         * @param errorSubject human-readable message of the exact error subject
         * @throws IllegalArgumentException if length % modFactor != 0
         */
        static void checkModLength(int length, int modFactor, String errorSubject) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Check if the file exists and is a file.
         *
         * @param file to check
         * @throws IllegalArgumentException if either file is null, does not exist or is not a file
         */
        private static void checkFileExists(java.io.File file) {
            if (file == null || !file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("file must not be null, has to exist and must be a file (not a directory) " + file);
            }
        }
    }

    /**
     * Util method related file operations.
     */
    static final class File {

        // 4K
        private static final int BUF_SIZE = 0x1000;

        private File() {
        }

        /**
         * Read bytes, buffered, from given input stream. Pass -1 to read the whole stream or limit with length
         * parameter.
         *
         * @param inputStream     to read from
         * @param maxLengthToRead how many bytes to read from input stream; pass -1 to read whole stream
         * @return all bytes from the stream (possibly limited by maxLengthToRead); output length is never longer than stream size
         */
        static byte[] readFromStream(InputStream inputStream, final int maxLengthToRead) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Read all bytes until length from given byte array.
         *
         * @param dataInput to read from
         * @return all bytes from the dataInput
         */
        static byte[] readFromDataInput(DataInput dataInput, int length) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reads all bytes from a file
         *
         * @param file the file to read
         * @return byte content
         */
        static byte[] readFromFile(java.io.File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reads bytes from file with given offset and max length
         *
         * @param file   to read bytes from
         * @param offset to read
         * @param length from offset
         * @return byte array with length
         */
        static byte[] readFromFile(java.io.File file, int offset, int length) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private Util() {
    }

    /**
     * A simple iterator for the bytes class, which does not support remove
     */
    static final class BytesIterator implements Iterator<java.lang.Byte> {

        private final byte[] array;

        /**
         * Index of element to be returned by subsequent call to next.
         */
        private int cursor = 0;

        BytesIterator(byte[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public java.lang.Byte next() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

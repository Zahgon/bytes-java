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
import java.math.BigInteger;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.*;

/**
 * "Bytes" is wrapper class for a byte-array that allows a lot of convenience operations on it:
 * <ul>
 * <li>Creation from various source: arrays, primitives, parsed or random</li>
 * <li>Encoding in many formats: hex, base64, etc.</li>
 * <li>Helper functions like: indexOf, count, entropy</li>
 * <li>Transformations like: append, reverse, xor, and, resize, ...</li>
 * <li>Conversation to other types: primitives, List, object array, ByteBuffer, BigInteger, ...</li>
 * <li>Validation: built-in or provided</li>
 * <li>Making it mutable or read-only</li>
 * </ul>
 * <p>
 * It supports byte ordering (little/big endianness).
 * <p>
 * This class is immutable as long as the internal array is not changed from outside (which can't be assured, when
 * using <code>wrap()</code>). It is possible to create a mutable version (see {@link MutableBytes}).
 * <p>
 * <strong>Example:</strong>
 * <pre>
 *     Bytes b = Bytes.from(array).mutable();
 *     b.not();
 *     System.out.println(b.encodeHex());
 * </pre>
 *
 * <h3>Comparable</h3>
 * The implemented comparator treats the bytes as signed bytes. If you want to sort, treating each byte as unsigned,
 * use {@link BytesTransformers#sortUnsigned()}.
 */
@SuppressWarnings("WeakerAccess")
public class Bytes implements Comparable<Bytes>, Serializable, Iterable<Byte> {

    private static final Bytes EMPTY = Bytes.wrap(new byte[0]);

    /* FACTORY ***************************************************************************************************/
    /**
     * Creates a new instance with an empty array filled with zeros.
     *
     * @param length of the internal array
     * @return new instance
     */
    public static Bytes allocate(int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with an empty array filled with given defaultValue
     *
     * @param length       of the internal array
     * @param defaultValue to fill with
     * @return new instance
     */
    public static Bytes allocate(int length, byte defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a Byte instance with an internal empty byte array. Same as calling {@link #allocate(int)} with 0.
     *
     * @return the empty instance (always the same reference
     */
    public static Bytes empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new reference backed by the same byte array.
     * Inherits all attributes (readonly, etc.)
     *
     * @param bytes to use as template
     * @return new instance
     */
    public static Bytes wrap(Bytes bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with given byte array.
     * <p>
     * The new instance will be backed by the given byte array;
     * that is, modifications to the bytes will cause the array to be modified
     * and vice versa.
     * <p>
     * If given array is null, a zero length byte array will be created and used instead.
     *
     * @param array to use directly or zero length byte array
     * @return new instance
     */
    public static Bytes wrapNullSafe(byte[] array) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with given byte array.
     * <p>
     * The new instance will be backed by the given byte array;
     * that is, modifications to the bytes will cause the array to be modified
     * and vice versa.
     *
     * @param array to use directly
     * @return new instance
     */
    public static Bytes wrap(byte[] array) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with given byte array.
     * <p>
     * The new instance will be backed by the given byte array;
     * that is, modifications to the bytes will cause the array to be modified
     * and vice versa.
     *
     * @param array     to use directly
     * @param byteOrder the byte order of passed array
     * @return new instance
     */
    public static Bytes wrap(byte[] array, ByteOrder byteOrder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given collections of single bytes.
     * This will create a copy of given bytes and will not directly use given bytes or byte array.
     *
     * @param byteArrayToCopy must not be null and will not be used directly, but a copy
     * @return new instance
     */
    public static Bytes from(byte[] byteArrayToCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given collections of single bytes.
     * This will create a copy of given bytes and will not directly use given bytes or byte array.
     * <p>
     * If given array is null, a zero length byte array will be created and used instead.
     *
     * @param byteArrayToCopy will not be used directly, but a copy; may be null
     * @return new instance
     */
    public static Bytes fromNullSafe(byte[] byteArrayToCopy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from a slice of given array
     *
     * @param array  to slice
     * @param offset start position
     * @param length length
     * @return new instance
     */
    public static Bytes from(byte[] array, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given array of byte arrays
     *
     * @param moreArrays must not be null
     * @return new instance
     */
    public static Bytes from(byte[]... moreArrays) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given array of byte arrays
     *
     * @param moreBytes must not be null
     * @return new instance
     */
    public static Bytes from(Bytes... moreBytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given collections. This will create a lot of auto-unboxing events,
     * so use with care with bigger lists.
     *
     * @param bytesCollection to create from
     * @return new instance
     */
    public static Bytes from(Collection<Byte> bytesCollection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given object byte array. Will copy and unbox every element.
     *
     * @param boxedObjectArray to create from
     * @return new instance
     */
    public static Bytes from(Byte[] boxedObjectArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new single array element array instance from given byte
     *
     * @param singleByte to create from
     * @return new instance
     */
    public static Bytes from(byte singleByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given collections of single bytes.
     * This will create a copy of given bytes and will not directly use given bytes or byte array.
     *
     * @param firstByte must not be null and will not be used directly, but a copy
     * @param moreBytes more bytes vararg
     * @return new instance
     */
    public static Bytes from(byte firstByte, byte... moreBytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given boolean.
     * This will create a new single array element array instance using the convention that false is zero.
     * E.g. Creates array <code>new byte[] {1}</code> if booleanValue is true and <code>new byte[] {0}</code> if
     * booleanValue is false.
     *
     * @param booleanValue to convert (false is zero, true is one)
     * @return new instance
     */
    public static Bytes from(boolean booleanValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given unsigned 2 byte char.
     *
     * @param char2Byte to create from
     * @return new instance
     */
    public static Bytes from(char char2Byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 2 byte short.
     *
     * @param short2Byte to create from
     * @return new instance
     */
    public static Bytes from(short short2Byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 2 byte short array.
     *
     * @param shortArray to create from
     * @return new instance
     */
    public static Bytes from(short... shortArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 4 byte integer.
     *
     * @param integer4byte to create from
     * @return new instance
     */
    public static Bytes from(int integer4byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 4 byte integer array.
     *
     * @param intArray to create from
     * @return new instance
     */
    public static Bytes from(int... intArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 8 byte long.
     *
     * @param long8byte to create from
     * @return new instance
     */
    public static Bytes from(long long8byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 8 byte long array.
     *
     * @param longArray to create from
     * @return new instance
     */
    public static Bytes from(long... longArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 4 byte floating point number (float).
     *
     * @param float4byte to create from
     * @return new instance
     */
    public static Bytes from(float float4byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given float array.
     *
     * @param floatArray to create from
     * @return new instance
     */
    public static Bytes from(float... floatArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given 8 byte floating point number (double).
     *
     * @param double8Byte to create from
     * @return new instance
     */
    public static Bytes from(double double8Byte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given double array.
     *
     * @param doubleArray to create from
     * @return new instance
     */
    public static Bytes from(double... doubleArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given {@link ByteBuffer}.
     * Will use the same backing byte array and honour the buffer's byte order.
     *
     * @param buffer to get the byte array from (must not be null)
     * @return new instance
     */
    public static Bytes from(ByteBuffer buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given {@link CharBuffer}.
     * Will ignore buffer's byte order and use {@link ByteOrder#BIG_ENDIAN}
     *
     * @param buffer to get the char array from (must not be null)
     * @return new instance
     */
    public static Bytes from(CharBuffer buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given {@link IntBuffer}.
     * Will ignore buffer's byte order and use {@link ByteOrder#BIG_ENDIAN}
     *
     * @param buffer to get the int array from (must not be null)
     * @return new instance
     */
    public static Bytes from(IntBuffer buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given {@link BitSet}.
     *
     * @param set to get the byte array from
     * @return new instance
     */
    public static Bytes from(BitSet set) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given {@link BigInteger}.
     *
     * @param bigInteger to get the byte array from
     * @return new instance
     */
    public static Bytes from(BigInteger bigInteger) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads given whole input stream and creates a new instance from read data
     *
     * @param stream to read from
     * @return new instance
     */
    public static Bytes from(InputStream stream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads given input stream up to maxLength and creates a new instance from read data.
     * Read maxLength is never longer than stream size (i.e. maxLength is only limiting, not assuring maxLength)
     *
     * @param stream    to read from
     * @param maxLength read to this maxLength or end of stream
     * @return new instance
     */
    public static Bytes from(InputStream stream, int maxLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads given {@link DataInput} and creates a new instance from read data
     *
     * @param dataInput to read from
     * @param length    how many bytes should be read
     * @return new instance
     */
    public static Bytes from(DataInput dataInput, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads given file and returns the byte content. Be aware that the whole file content will be loaded to
     * memory, so be careful what to read in.
     *
     * @param file to read from
     * @return new instance
     * @throws IllegalArgumentException if file does not exist
     * @throws IllegalStateException    if file could not be read
     */
    public static Bytes from(File file) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads given file and returns the byte content. Be aware that the whole defined file content will be loaded to
     * memory, so be careful what to read in. This uses {@link java.io.RandomAccessFile} under the hood.
     *
     * @param file   to read from
     * @param offset byte offset from zero position of the file
     * @param length to read from offset
     * @return new instance
     * @throws IllegalArgumentException if file does not exist
     * @throws IllegalStateException    if file could not be read
     */
    public static Bytes from(File file, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given utf-8 encoded string
     *
     * @param utf8String to get the internal byte array from
     * @return new instance
     */
    public static Bytes from(CharSequence utf8String) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from normalized form of given utf-8 encoded string
     *
     * @param utf8String to get the internal byte array from
     * @param form       to normalize, usually you want {@link java.text.Normalizer.Form#NFKD} for compatibility
     * @return new instance
     */
    public static Bytes from(CharSequence utf8String, Normalizer.Form form) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given string
     *
     * @param string  to get the internal byte array from
     * @param charset used to decode the string
     * @return new instance
     */
    public static Bytes from(CharSequence string, Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given char array using utf-8 encoding
     *
     * @param charArray to get the internal byte array from
     * @return new instance
     */
    public static Bytes from(char[] charArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given char array. The array will be handles like an encoded string
     *
     * @param charArray to get the internal byte array from
     * @param charset   charset to be used to decode the char array
     * @return new instance
     */
    public static Bytes from(char[] charArray, Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance from given char array with given range. The array will be handles like an encoded string
     *
     * @param charArray to get the internal byte array from
     * @param charset   charset to be used to decode the char array
     * @param offset    start position (from given char array not encoded byte array out)
     * @param length    length in relation to offset (from given char array not encoded byte array out)
     * @return new instance
     */
    public static Bytes from(char[] charArray, Charset charset, int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert UUID to a newly generated 16 byte long array representation. Puts the 8 byte most significant bits and
     * 8 byte the least significant bits into a byte array.
     *
     * @param uuid to convert to array
     * @return new instance
     */
    public static Bytes from(UUID uuid) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parses a big endian binary string (e.g. <code>10010001</code>)
     *
     * @param binaryString the encoded string
     * @return decoded instance
     */
    public static Bytes parseBinary(CharSequence binaryString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of octal encoded byte arrays.
     *
     * @param octalString the encoded string
     * @return decoded instance
     */
    public static Bytes parseOctal(CharSequence octalString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of decimal encoded byte arrays.
     *
     * @param decString the encoded string
     * @return decoded instance
     */
    public static Bytes parseDec(CharSequence decString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encodes with given radix string representation (e.g. radix 16 would be hex).
     * See also {@link BigInteger#toString(int)}.
     * <p>
     * This is usually a number encoding, not a data encoding (i.e. leading zeros are not preserved), but this implementation
     * tries to preserve the leading zeros, to keep the in/output byte length size the same, but use at your own risk!
     *
     * @param radixNumberString the encoded string
     * @param radix             radix of the String representation (supported are 2-36)
     * @return decoded instance
     */
    public static Bytes parseRadix(CharSequence radixNumberString, int radix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of base16/HEX encoded byte arrays. This is by design a very flexible decoder accepting the following cases:
     *
     * <ul>
     *     <li>Upper- and lowercase <code>a-f</code> (also mixed case)</li>
     *     <li>Prefix with <code>0x</code> which will be ignored</li>
     *     <li>Even and odd number of string length with auto zero padding (i.e. 'E3F' is same as '0E3F')</li>
     * </ul>
     *
     * @param hexString the encoded string
     * @return decoded instance
     * @throws IllegalArgumentException if string contains something else than [0-9a-fA-F]
     */
    public static Bytes parseHex(CharSequence hexString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of base32/RFC 4648 encoded byte arrays.
     * <p>
     * Uses the RFC 4648 non-hex alphabet, see <a href="https://en.wikipedia.org/wiki/Base32#RFC_4648_Base32_alphabet">Base32 alphabet</a>.
     *
     * @param base32Rfc4648String the encoded string
     * @return decoded instance
     */
    public static Bytes parseBase32(CharSequence base32Rfc4648String) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of base36 encoded byte arrays.
     * <p>
     * This is usually a number encoding, not a data encoding (i.e. leading zeros are not preserved), but this implementation
     * tries to preserve the leading zeros, to keep the in/output byte length size the same.
     *
     * @param base36String the encoded string
     * @return decoded instance
     * @deprecated use {@link #parseRadix(CharSequence, int)} with 36 instead; will be removed in v1.0+
     */
    @Deprecated
    public static Bytes parseBase36(CharSequence base36String) {
        return parse(base36String, new BinaryToTextEncoding.BaseRadixNumber(36));
    }

    /**
     * Parsing of base64 encoded byte arrays.
     * Supporting RFC 4648 normal and url safe encoding, with or without padding.
     *
     * @param base64String the encoded string
     * @return decoded instance
     */
    public static Bytes parseBase64(CharSequence base64String) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parsing of arbitrary encoded format
     *
     * @param encoded the encoded string
     * @param decoder the decoder used to decode the string
     * @return decoded instance
     */
    public static Bytes parse(CharSequence encoded, BinaryToTextEncoding.Decoder decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A new instance with random bytes. Uses a cryptographically secure {@link SecureRandom} instance.
     *
     * @param length desired array length
     * @return random instance
     */
    public static Bytes random(int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A new instance with pseudo random bytes using an unsecure random number generator.
     * This may be used in e.g. tests. In production code use {@link #random(int)} per default.
     * <p>
     * <strong>ONLY USE IN NON-SECURITY RELEVANT CONTEXT!</strong>
     *
     * @param length desired array length
     * @return random instance
     */
    public static Bytes unsecureRandom(int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A new instance with pseudo random bytes using an unsecure random number generator.
     * This may be used in e.g. tests to create predictable numbers.
     * <p>
     * In production code use {@link #random(int)} per default.
     * <p>
     * <strong>ONLY USE IN NON-SECURITY RELEVANT CONTEXT!</strong>
     *
     * @param length desired array length
     * @param seed   used to seed random number generator - using same seed will generate same numbers
     * @return random instance
     */
    public static Bytes unsecureRandom(int length, long seed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A new instance with random bytes.
     *
     * @param length desired array length
     * @param random to create the entropy for the random bytes
     * @return random instance
     */
    public static Bytes random(int length, Random random) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* OBJECT ****************************************************************************************************/
    private final byte[] byteArray;

    private final ByteOrder byteOrder;

    private final BytesFactory factory;

    Bytes(byte[] byteArray, ByteOrder byteOrder) {
        this(byteArray, byteOrder, new Factory());
    }

    /**
     * Creates a new immutable instance
     *
     * @param byteArray internal byte array
     * @param byteOrder the internal byte order - this is used to interpret given array, not to change it
     */
    Bytes(byte[] byteArray, ByteOrder byteOrder, BytesFactory factory) {
        this.byteArray = byteArray;
        this.byteOrder = byteOrder;
        this.factory = factory;
    }

    /* TRANSFORMER **********************************************************************************************/
    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end).
     * <p>
     * This will create a new byte array internally, so it is not suitable to use as extensive builder pattern -
     * use {@link ByteBuffer} or {@link java.io.ByteArrayOutputStream} for that.
     *
     * @param bytes to append
     * @return appended instance
     */
    public Bytes append(Bytes bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param singleByte to append
     * @return appended instance
     */
    public Bytes append(byte singleByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param char2Bytes to append
     * @return appended instance
     */
    public Bytes append(char char2Bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param short2Bytes to append
     * @return appended instance
     */
    public Bytes append(short short2Bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param integer4Bytes to append
     * @return appended instance
     */
    public Bytes append(int integer4Bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param long8Bytes to append
     * @return appended instance
     */
    public Bytes append(long long8Bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end).
     * You may use this to append multiple byte arrays without the need for chaining the {@link #append(byte[])} call
     * and therefore generating intermediate copies of the byte array, making this approach use less memory.
     *
     * @param arrays to append
     * @return appended instance
     */
    public Bytes append(byte[]... arrays) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     *
     * @param secondArray to append
     * @return appended instance
     */
    public Bytes append(byte[] secondArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided data (i.e. append at the end)
     * <p>
     * If given array is null, the nothing will be appended.
     *
     * @param secondArrayNullable to append, may be null
     * @return appended instance or same if passed array is null
     */
    public Bytes appendNullSafe(byte[] secondArrayNullable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided utf-8 encoded representation of this string
     *
     * @param stringUtf8 string used to get utf-8 bytes from
     * @return appended instance
     */
    public Bytes append(CharSequence stringUtf8) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with the current array appended to the provided string with provided encoding
     *
     * @param string  string used to get bytes from
     * @param charset encoding of provided string
     * @return appended instance
     */
    public Bytes append(CharSequence string, Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise XOR operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param bytes must be of same length as this instance
     * @return xor'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#XOR">Bitwise operators: XOR</a>
     */
    public Bytes xor(Bytes bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise XOR operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param secondArray must be of same length as this instance
     * @return xor'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#XOR">Bitwise operators: XOR</a>
     */
    public Bytes xor(byte[] secondArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise AND operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param bytes must be of same length as this instance
     * @return and'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#AND">Bitwise operators: AND</a>
     */
    public Bytes and(Bytes bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise AND operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param secondArray must be of same length as this instance
     * @return and'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#AND">Bitwise operators: AND</a>
     */
    public Bytes and(byte[] secondArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise OR operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param bytes must be of same length as this instance
     * @return or'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#OR">Bitwise operators: OR</a>
     */
    public Bytes or(Bytes bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise OR operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param secondArray must be of same length as this instance
     * @return or'ed instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#OR">Bitwise operators: OR</a>
     */
    public Bytes or(byte[] secondArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise not operation on the whole internal byte array.
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @return negated instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#NOT">Bitwise operators: NOT</a>
     */
    public Bytes not() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise left shifting of internal byte array (i.e. <code>&#x3C;&#x3C;</code>). Unlike {@link BigInteger}'s implementation, this one will never
     * grow or shrink the underlying array. Either a bit is pushed out of the array or a zero is pushed in.
     * <p>
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param shiftCount how many bits (not bytes)
     * @return shifted instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Bit_shifts">Bit shifts</a>
     */
    public Bytes leftShift(int shiftCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bitwise unsigned/logical right shifting of internal byte array (i.e. <code>&#x3E;&#x3E;&#x3E;</code>). Unlike
     * {@link BigInteger}'s implementation, this one will never grow or shrink the underlying array. Either a bit is pushed
     * out of the array or a zero is pushed in.
     * <p>
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @param shiftCount how many bits (not bytes)
     * @return shifted instance
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Bit_shifts">Bit shifts</a>
     */
    public Bytes rightShift(int shiftCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a Byte whose value is equivalent to this Byte with the designated bit set to newBitValue. Bits start to count from the LSB (i.e. Bytes.from(0).switchBit(0,true) == 1)
     *
     * @param bitPosition not to confuse with byte position
     * @param newBitValue if true set to 1, 0 otherwise
     * @return instance with bit switched
     */
    public Bytes switchBit(int bitPosition, boolean newBitValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a Byte whose value is equivalent to this Byte with the designated bit switched.
     *
     * @param bitPosition not to confuse with byte position
     * @return instance with bit switched
     */
    public Bytes switchBit(int bitPosition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with a copy of the internal byte array and all other attributes.
     *
     * @return copied instance
     */
    public Bytes copy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new instance with a copy of the internal byte array and all other attributes.
     *
     * @param offset starting position in the source array
     * @param length of the new instance
     * @return copied instance
     */
    public Bytes copy(int offset, int length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reverses the internal bytes in the array (not bits in each byte)
     * <p>
     * See the considerations about possible in-place operation in {@link #transform(BytesTransformer)}.
     *
     * @return reversed instance
     */
    public Bytes reverse() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary)
     * so the copy has the specified length.  For all indices that are
     * valid in both the original array and the copy, the two arrays will
     * contain identical values.  For any indices that are valid in the
     * copy but not the original, the copy will contain {@code (byte)0}.
     * <p>
     * Resize from LSB or length, so an array [0,1,2,3] resized to 3 will result in [1,2,3] or resized to 5 [0,0,1,2,3].
     * So when an 8 byte value resized to 4 byte will result in the same 32-bit integer value
     *
     * @param newByteLength the length of the copy to be returned
     * @return a copy with the desired size or "this" instance if newByteLength == current length
     */
    public Bytes resize(int newByteLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary)
     * so the copy has the specified length.  For all indices that are
     * valid in both the original array and the copy, the two arrays will
     * contain identical values.  For any indices that are valid in the
     * copy but not the original, the copy will contain {@code (byte)0}.
     * <p>
     * <strong>Modes:</strong>
     * <ul>
     * <li>{@link BytesTransformer.ResizeTransformer.Mode#RESIZE_KEEP_FROM_ZERO_INDEX}: Resize from MSB or index 0;
     * so an array [0,1,2,3] resized to 3 will result in [0,1,2] or resized to 5 [0,1,2,3,0]</li>
     * <li>{@link BytesTransformer.ResizeTransformer.Mode#RESIZE_KEEP_FROM_MAX_LENGTH}: Resize from LSB or length;
     * so an array [0,1,2,3] resized to 3 will result in [1,2,3] or resized to 5 [0,0,1,2,3]</li>
     * </ul>
     *
     * @param newByteLength the length of the copy to be returned
     * @param mode          from which end the length will start to count (either index 0 or length())
     * @return a copy with the desired size or "this" instance if newByteLength == current length
     */
    public Bytes resize(int newByteLength, BytesTransformer.ResizeTransformer.Mode mode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates md5 on the underlying byte array and returns a byte instance containing the hash.
     * This hash algorithm SHOULD be supported by every JVM implementation (see
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html">Javadoc for MessageDigest</a>)
     * <p>
     * <strong>Do not use this algorithm in security relevant applications.</strong>
     *
     * @return md5 (16 bytes) hash of internal byte array
     * @throws IllegalArgumentException if the message digest algorithm can not be found in the security providers
     * @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
     */
    public Bytes hashMd5() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates sha1 on the underlying byte array and returns a byte instance containing the hash.
     * This hash algorithm SHOULD be supported by every JVM implementation (see
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html">Javadoc for MessageDigest</a>)
     * <p>
     * <strong>Do not use this algorithm in security relevant applications.</strong>
     *
     * @return sha1 (20 bytes) hash of internal byte array
     * @throws IllegalArgumentException if the message digest algorithm can not be found in the security providers
     * @see <a href="https://en.wikipedia.org/wiki/SHA-1">Secure Hash Algorithm 1</a>
     */
    public Bytes hashSha1() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates sha256 on the underlying byte array and returns a byte instance containing the hash.
     *
     * @return sha256 (32 bytes) hash of internal byte array
     * @throws IllegalArgumentException if the message digest algorithm can not be found in the security providers
     * @see <a href="https://en.wikipedia.org/wiki/Secure_Hash_Algorithms">Secure Hash Algorithms</a>
     */
    public Bytes hashSha256() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates hash with provided algorithm on the underlying byte array and returns a byte instance
     * containing the hash.
     *
     * @param algorithm same format as passed to {@link java.security.MessageDigest#getInstance(String)}
     * @return hash of internal byte array
     * @throws IllegalArgumentException if the message digest algorithm can not be found in the security providers
     */
    public Bytes hash(String algorithm) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Generic transformation of this instance.
     * <p>
     * This transformation might be done in-place (i.e. without copying the internal array and overwriting its old state),
     * or on a copy of the internal data, depending on the type (e.g. {@link MutableBytes}) and if the operation can be done
     * in-place. Therefore, the caller has to ensure that certain side effects, which occur due to the changing of the internal
     * data, do not create bugs in his/her code. Usually immutability is preferred, but when handling many or big byte arrays,
     * mutability enables drastically better performance.
     *
     * @param transformer used to transform this instance
     * @return the transformed instance (might be the same, or a new one)
     */
    public Bytes transform(BytesTransformer transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* VALIDATORS ***************************************************************************************************/
    /**
     * Checks the content of each byte for 0 values
     *
     * @return true if not empty and only contains zero byte values
     */
    public boolean validateNotOnlyZeros() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies all given validators and returns true if all of them return true (default AND concatenation).
     *
     * @param bytesValidators array of validators to check against the byte array
     * @return true if all validators return true
     */
    public boolean validate(BytesValidator... bytesValidators) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* ATTRIBUTES ************************************************************************************************/
    /**
     * The byte length of the underlying byte array.
     *
     * @return byte length
     */
    public int length() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The bit length of the underlying byte array.
     *
     * @return the bit length
     */
    public int lengthBit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks the internal array for emptiness.
     *
     * @return if the underlying byte array has a length of 0
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the set byte order/endianness. Default in Java is {@link ByteOrder#BIG_ENDIAN}.
     *
     * @return either {@link ByteOrder#BIG_ENDIAN} or {@link ByteOrder#LITTLE_ENDIAN}
     * @see <a href="https://en.wikipedia.org/wiki/Endianness">Endianness</a>
     */
    public ByteOrder byteOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if instance is mutable
     *
     * @return true if mutable, i.e. transformers will change internal array
     */
    public boolean isMutable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Check if this instance is read only
     *
     * @return true if read only
     */
    public boolean isReadOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if given byte value is contained in internal array
     *
     * @param target a primitive {@code byte} value
     * @return true if this Bytes instance contains the specified element
     */
    public boolean contains(byte target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the index of the first appearance of the value {@code target} in
     * {@code array}. Same as calling {@link #indexOf(byte, int)} with fromIndex '0'.
     *
     * @param target a primitive {@code byte} value
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists.
     */
    public int indexOf(byte target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the index of the first appearance of the value {@code target} in
     * {@code array} from given start index 'fromIndex'.
     *
     * @param target    a primitive {@code byte} value
     * @param fromIndex search from this index
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists or fromIndex is gt target length.
     */
    public int indexOf(byte target, int fromIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the index of the first appearance of the value {@code target} in
     * {@code array} from given start index 'fromIndex' to given end index 'toIndex'.
     *
     * @param target    a primitive {@code byte} value
     * @param fromIndex search from this index
     * @param toIndex   search to this index
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists or fromIndex is gt target length.
     */
    public int indexOf(byte target, int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the start position of the first occurrence of the specified {@code
     * target} within {@code array}, or {@code -1} if there is no such occurrence.
     * <p>
     * More formally, returns the lowest index {@code i} such that {@code
     * java.util.Arrays.copyOfRange(array, i, i + target.length)} contains exactly
     * the same elements as {@code target}.
     *
     * @param subArray the array to search for as a sub-sequence of {@code array}
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists.
     */
    public int indexOf(byte[] subArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the start position of the first occurrence of the specified {@code
     * target} within {@code array} from given start index 'fromIndex', or {@code -1}
     * if there is no such occurrence.
     * <p>
     * More formally, returns the lowest index {@code i} such that {@code
     * java.util.Arrays.copyOfRange(array, i, i + target.length)} contains exactly
     * the same elements as {@code target}.
     *
     * @param subArray  the array to search for as a sub-sequence of {@code array}
     * @param fromIndex search from this index
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists.
     */
    public int indexOf(byte[] subArray, int fromIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the start position of the first occurrence of the specified {@code
     * target} within {@code array} from given start index 'fromIndex' to given end
     * index 'toIndex', or {@code -1} if there is no such occurrence.
     * <p>
     * More formally, returns the lowest index {@code i} such that {@code
     * java.util.Arrays.copyOfRange(array, i, i + target.length)} contains exactly
     * the same elements as {@code target}.
     *
     * @param subArray  the array to search for as a sub-sequence of {@code array}
     * @param fromIndex search from this index
     * @param toIndex search to this index
     * @return the least index {@code i} for which {@code array[i] == target}, or
     * {@code -1} if no such index exists.
     */
    public int indexOf(byte[] subArray, int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the given sub array is equal to the start of given array. That is, sub array must be gt or eq
     * to the length of the internal array and <code>internal[i] == subArray[i]</code> for i=0..subArray.length-1
     *
     * @param subArray to check against the start of the internal array
     * @return true if the start of the internal array is eq to given sub array
     */
    public boolean startsWith(byte[] subArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the index of the last appearance of the value {@code target} in
     * {@code array}.
     *
     * @param target a primitive {@code byte} value
     * @return the greatest index {@code i} for which {@code array[i] == target},
     * or {@code -1} if no such index exists.
     */
    public int lastIndexOf(byte target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the given sub array is equal to the end of given array. That is, sub array must be gt or eq
     * to the length of the internal array and <code>internal[i] == subArray[i]</code> for i=subArray.length...internal.length
     *
     * @param subArray to check against the end of the internal array
     * @return true if the end of the internal array is eq to given sub array
     */
    public boolean endsWith(byte[] subArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code bit} value as boolean at the specified index. Bit index 0 is the LSB, so for example byte word
     * <code>1000 0000</code> has <code>bitAt(0) == false</code> and <code>bitAt(7) == true</code>.
     *
     * @param bitIndex the index of the {@code bit} value.
     * @return true if the bit at given index is set, false otherwise
     * @throws IndexOutOfBoundsException if the {@code bitIndex} argument is negative or not less than the length of this array in bits.
     */
    public boolean bitAt(int bitIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code byte} value at the specified index.
     * An index ranges from {@code 0} to {@code length() - 1}. The first {@code char} value of the sequence
     * is at index {@code 0}, the next at index {@code 1}, and so on, as for array indexing.
     *
     * @param index the index of the {@code byte} value.
     * @return the {@code byte} value at the specified index of the underlying byte array.
     * @throws IndexOutOfBoundsException if the {@code index} argument is negative or not less than the length of this array.
     */
    public byte byteAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the unsigned {@code byte} value at the specified index as an int.
     * An index ranges from {@code 0} to {@code length() - 1}. The first {@code char} value of the sequence
     * is at index {@code 0}, the next at index {@code 1}, and so on, as for array indexing.
     *
     * @param index the index of the unsigned {@code byte} value.
     * @return the unsigned {@code byte} value at the specified index of the underlying byte array as type 4 byte integer
     * @throws IndexOutOfBoundsException if the {@code index} argument is negative or not less than the length of this array.
     */
    public int unsignedByteAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code char} value at the specified index.
     * Reads the primitive from given index and the following byte and interprets it according to byte order.
     *
     * @param index the index of the {@code char} value.
     * @return the {@code char} value at the specified index of the underlying byte array.
     * @throws IndexOutOfBoundsException if the {@code index} argument is negative or length is greater than index - 2
     */
    public char charAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code short} value at the specified index.
     * Reads the primitive from given index and the following byte and interprets it according to byte order.
     *
     * @param index the index of the {@code short} value.
     * @return the {@code short} value at the specified index of the underlying byte array.
     * @throws IndexOutOfBoundsException if the {@code index} argument is negative or length is greater than index - 2
     */
    public short shortAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code int} value at the specified index.
     * Reads the primitive from given index and the following 3 bytes and interprets it according to byte order.
     *
     * @param index the index of the {@code int} value.
     * @return the {@code int} value at the specified index of the underlying byte array.
     * @throws IndexOutOfBoundsException if the {@code int} argument is negative or length is greater than index - 4
     */
    public int intAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the {@code long} value at the specified index.
     * Reads the primitive from given index and the following 7 bytes and interprets it according to byte order.
     *
     * @param index the index of the {@code long} value.
     * @return the {@code long} value at the specified index of the underlying byte array.
     * @throws IndexOutOfBoundsException if the {@code long} argument is negative or length is greater than index - 8
     */
    public long longAt(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Traverses the internal byte array counts the occurrences of given byte.
     * This has a time complexity of O(n).
     *
     * @param target byte to count
     * @return the count of given target in the byte array
     */
    public int count(byte target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Traverses the internal byte array counts the occurrences of given pattern array.
     * This has a time complexity of O(n).
     * <p>
     * Example:
     * <ul>
     * <li>Internal Array: [0, 1, 2, 0, 1, 0]</li>
     * <li>Pattern Array: [0, 1]</li>
     * <li>Count: 2</li>
     * </ul>
     *
     * @param pattern byte array to count
     * @return the count of given target in the byte array
     */
    public int count(byte[] pattern) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates the entropy of the internal byte array. This might be useful for judging the internal data
     * for using e.g. in security relevant use case. In statistical mechanics, entropy is related to the number of
     * microscopic configurations Ω that a thermodynamic system can have when in a state as specified by some macroscopic
     * variables. Specifically, assuming for simplicity that each of the microscopic configurations is equally probable,
     * the entropy of the system is the natural logarithm of that number of configurations, multiplied by the Boltzmann constant kB.
     * <p>
     * This implementation requires O(n) time and O(1) space complexity.
     *
     * @return entropy value; higher is more entropy (simply: more different values)
     * @see <a href="https://en.wikipedia.org/wiki/Entropy">Entropy</a>
     */
    public double entropy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* CONVERTERS POSSIBLY REUSING THE INTERNAL ARRAY ***************************************************************/
    /**
     * Create a new instance which shares the same underlying array
     *
     * @return new instance backed by the same data
     */
    public Bytes duplicate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the byte order or endianness of this instance. Default in Java is {@link ByteOrder#BIG_ENDIAN}.
     * <p>
     * This option is important for all encoding and conversion methods.
     *
     * @param byteOrder new byteOrder
     * @return a new instance with the same underlying array and new order, or "this" if order is the same
     * @see <a href="https://en.wikipedia.org/wiki/Endianness">Endianness</a>
     */
    public Bytes byteOrder(ByteOrder byteOrder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new read-only byte instance. Read-only means, that there is no direct access to the underlying byte
     * array and all transformers will create a copy.
     *
     * @return a new instance if not already readonly, or "this" otherwise
     */
    public ReadOnlyBytes readOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The internal byte array wrapped in a {@link ByteBuffer} instance.
     * Changes to it will be directly mirrored in this {@link Bytes} instance.
     * <p>
     * This will honor the set {@link #byteOrder()}.
     *
     * @return byte buffer
     * @throws ReadOnlyBufferException if this is a read-only instance
     */
    public ByteBuffer buffer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ByteBuffer internalBuffer() {
        return ByteBuffer.wrap(internalArray()).order(byteOrder);
    }

    /**
     * Returns a mutable version of this instance with sharing the same underlying byte-array.
     * If you want the mutable version to be a copy, call {@link #copy()} first.
     *
     * @return new mutable instance with same reference to internal byte array, or "this" if this is already of type {@link MutableBytes}
     * @throws ReadOnlyBufferException if this is a read-only instance
     */
    public MutableBytes mutable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an input stream with the same backing data as the intern array of this instance
     *
     * @return new input stream
     */
    public InputStream inputStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The reference of te internal byte-array. This call requires no conversation or additional memory allocation.
     * <p>
     * Modifications to these byte's content will cause the returned
     * array's content to be modified, and vice versa.
     *
     * @return the direct reference of the internal byte array
     * @throws ReadOnlyBufferException if this is a read-only instance
     */
    public byte[] array() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    byte[] internalArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* ENCODER ************************************************************************************************/
    /**
     * Binary (aka "1" and "0") representation. This is especially useful for debugging purposes.
     * Binary has a space efficiency of 12.5%.
     * <p>
     * Example: <code>10011100</code>
     *
     * @return binary string
     * @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
     */
    public String encodeBinary() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Octal (0-7) representation. Octal has a space efficiency of 37.5%.
     * <p>
     * Example: <code>1124517677707527755</code>
     *
     * @return octal number as string
     * @see <a href="https://en.wikipedia.org/wiki/Octal">Octal</a>
     */
    public String encodeOctal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decimal (0-9) representation. It has a space efficiency of 41.5%.
     * <p>
     * Example: <code>20992966904426477</code>
     *
     * @return decimal number as string
     * @see <a href="https://en.wikipedia.org/wiki/Decimal">Decimal</a>
     */
    public String encodeDec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encodes the internal array in given radix representation (e.g. 2 = binary, 10 = decimal, 16 = hex).
     * <p>
     * This is usually a number encoding, not a data encoding (i.e. leading zeros are not preserved), but this implementation
     * tries to preserve the leading zeros, to keep the in/output byte length size the same. To preserve the length padding
     * would be required, but is not supported in this implementation.
     * <p>
     * But still full disclaimer:
     * <p>
     * <strong>This is NOT recommended for data encoding, only for number encoding</strong>
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Radix_economy">Radix Economy</a> and {@link BigInteger#toString(int)}.
     *
     * @param radix of the String representation (supported are 2-36)
     * @return string in given radix representation
     */
    public String encodeRadix(int radix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Base16 or Hex representation in lowercase. 2 characters represent a single byte, it therefore has an efficiency of 50%.
     * <p>
     * Example: <code>4a94fdff1eafed</code>
     *
     * @return hex string
     * @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
     */
    public String encodeHex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Base16 or Hex representation. See {@link #encodeHex()}.
     * <p>
     * Example: <code>4A94FDFF1EAFED</code>
     *
     * @param upperCase if the output character should be in uppercase
     * @return hex string
     */
    public String encodeHex(boolean upperCase) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Base32 RFC4648 string representation of the internal byte array (not Base32 hex alphabet extension)
     * <p>
     * Example: <code>MZXW6YQ=</code>
     * <p>
     * See <a href="https://tools.ietf.org/html/rfc4648">RFC 4648</a>
     *
     * @return base32 string
     */
    public String encodeBase32() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * DO NOT USE AS DATA ENCODING, ONLY FOR NUMBERS!
     * <p>
     * Base36 (aka Hexatrigesimal) representation. The choice of 36 is convenient in that the digits can be
     * represented using the Arabic numerals 0–9 and the Latin letters A–Z. This encoding has a space efficiency of 64.6%.
     * <p>
     * Example: <code>5qpdvuwjvu5</code>
     *
     * @return base36 string
     * @see <a href="https://en.wikipedia.org/wiki/Base36">Base36</a>
     * @deprecated use {@link #encodeRadix(int)} instead; will be removed in v1.0+
     */
    @Deprecated
    public String encodeBase36() {
        return encodeRadix(36);
    }

    /**
     * Base64 representation with padding. This is *NOT* the url safe variation. This encoding has a space efficiency of 75%.
     * <p>
     * This encoding is <a href="https://tools.ietf.org/html/rfc4648">RFC 4648</a> compatible.
     * <p>
     * Example: <code>SpT9/x6v7Q==</code>
     *
     * @return base64 string
     * @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
     */
    public String encodeBase64() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Base64 representation with padding. This is the url safe variation substitution '+' and '/' with '-' and '_'
     * respectively. This encoding has a space efficiency of 75%.
     * <p>
     * This encoding is <a href="https://tools.ietf.org/html/rfc4648">RFC 4648</a> compatible.
     * <p>
     * Example: <code>SpT9_x6v7Q==</code>
     *
     * @return base64 url safe string
     * @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
     */
    public String encodeBase64Url() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Base64 representation with either padding or without and with or without URL and filename safe alphabet.
     * This encoding is <a href="https://tools.ietf.org/html/rfc4648">RFC 4648</a> compatible.
     * <p>
     * Example: <code>SpT9/x6v7Q==</code>
     *
     * @param urlSafe     if true will substitute '+' and '/' with '-' and '_'
     * @param withPadding if true will add padding the next full byte with '='
     * @return base64 url safe string
     * @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
     */
    public String encodeBase64(boolean urlSafe, boolean withPadding) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * UTF-8 representation of this byte array
     *
     * @return utf-8 encoded string
     * @see <a href="https://en.wikipedia.org/wiki/UTF-8">UTF-8</a>
     */
    public String encodeUtf8() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * String representation with given charset encoding
     *
     * @param charset the charset the return will be encoded
     * @return encoded string
     */
    public String encodeCharset(Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * UTF-8 representation of this byte array as byte array
     * <p>
     * Similar to <code>encodeUtf8().getBytes(StandardCharsets.UTF_8)</code>.
     *
     * @return utf-8 encoded byte array
     * @see <a href="https://en.wikipedia.org/wiki/UTF-8">UTF-8</a>
     */
    public byte[] encodeUtf8ToBytes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Byte array representation with given charset encoding.
     * <p>
     * Similar to <code>encodeCharset(charset).getBytes(charset)</code>.
     *
     * @param charset the charset the return will be encoded
     * @return encoded byte array
     */
    public byte[] encodeCharsetToBytes(Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode the internal byte-array with given encoder.
     *
     * @param encoder the encoder implementation
     * @return byte-to-text representation
     */
    public String encode(BinaryToTextEncoding.Encoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* CONVERTERS WITHOUT REUSING THE INTERNAL ARRAY ****************************************************************/
    /**
     * Returns a copy of the internal byte-array as {@link List} collection type
     * This requires a time and space complexity of O(n).
     *
     * @return copy of internal array as list
     */
    public List<Byte> toList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a copy of the internal byte-array as boxed primitive array.
     * This requires a time and space complexity of O(n).
     * <p>
     * Note: this method was previously called <code>toObjectArray()</code>
     *
     * @return copy of internal array as object array
     */
    public Byte[] toBoxedArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a copy of the internal byte-array as {@link BitSet} type
     *
     * @return bit set with the content of the internal array
     */
    public BitSet toBitSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The internal byte array wrapped in a {@link BigInteger} instance.
     * <p>
     * If the internal byte order is {@link ByteOrder#LITTLE_ENDIAN}, a copy of the internal
     * array will be reversed and used as backing array with the big integer. Otherwise, the internal
     * array will be used directly.
     *
     * @return big integer
     */
    public BigInteger toBigInteger() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a {@link UUID} instance of the internal byte array. This requires the internal array to be exactly 16 bytes. Takes the first
     * 8 byte as mostSigBits and the last 8 byte as leastSigBits. There is no validation of version/type, just passes the raw bytes
     * to a {@link UUID} constructor.
     *
     * @return newly created UUID
     * @throws IllegalArgumentException if byte array has length not equal to 16
     */
    public UUID toUUID() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 1 byte / 8 bit long, returns signed two-complement
     * representation for a Java byte value.
     * <p>
     * If you just want to get the first element as {@code byte}, see {@link #byteAt(int)}, using index zero.
     *
     * @return the byte representation
     * @throws IllegalArgumentException if byte array has length not equal to 1
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public byte toByte() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 1 byte / 8 bit long, returns unsigned two-complement
     * representation for a Java byte value wrapped in an 4 byte int.
     * <p>
     * If you just want to get the first element as {@code byte}, see {@link #byteAt(int)}, using index zero.
     *
     * @return the unsigned byte representation wrapped in an int
     * @throws IllegalArgumentException if byte array has length not equal to 1
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public int toUnsignedByte() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 2 byte / 16 bit long, return unsigned two-complement
     * representation for a Java char integer value. The output is dependent on the set {@link #byteOrder()}.
     * <p>
     * If you just want to get the first 2 bytes as {@code char}, see {@link #charAt(int)} using index zero.
     *
     * @return the int representation
     * @throws IllegalArgumentException if byte array has length not equal to 2
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public char toChar() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 2 byte / 16 bit long, return signed two-complement
     * representation for a Java short integer value. The output is dependent on the set {@link #byteOrder()}.
     * <p>
     * If you just want to get the first 2 bytes as {@code short}, see {@link #shortAt(int)} using index zero.
     *
     * @return the int representation
     * @throws IllegalArgumentException if byte array has length not equal to 2
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public short toShort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 4 byte / 32 bit long, return signed two-complement
     * representation for a Java signed integer value. The output is dependent on the set {@link #byteOrder()}.
     * <p>
     * If you just want to get the first 4 bytes as {@code int}, see {@link #intAt(int)} using index zero.
     *
     * @return the int representation
     * @throws IllegalArgumentException if byte array has length not equal to 4
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public int toInt() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the internal byte array to an int array, that is, every 4 bytes will be packed into a single int.
     * <p>
     * E.g. 4 bytes will be packed to a length 1 int array:
     * <pre>
     *  [b1, b2, b3, b4] = [int1]
     * </pre>
     * <p>
     * This conversion respects the internal byte order. Will only work if all bytes can be directly mapped to int,
     * which means the byte array length must be dividable by 4 without rest.
     *
     * @return new int[] instance representing this byte array
     * @throws IllegalArgumentException if internal byte length mod 4 != 0
     */
    public int[] toIntArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 8 byte / 64 bit long, return signed two-complement
     * representation for a Java signed long integer value. The output is dependent on the set {@link #byteOrder()}.
     * <p>
     * If you just want to get the first 4 bytes as {@code long}, see {@link #longAt(int)} using index zero.
     *
     * @return the long representation
     * @throws IllegalArgumentException if byte array has length not equal to 8
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public long toLong() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the internal byte array to a long array, that is, every 8 bytes will be packed into a single long.
     * <p>
     * E.g. 8 bytes will be packed to a length 1 long array:
     * <pre>
     *  [b1, b2, b3, b4, b5, b6, b7, b8] = [int1]
     * </pre>
     * <p>
     * This conversion respects the internal byte order. Will only work if all bytes can be directly mapped to long,
     * which means the byte array length must be dividable by 8 without rest.
     *
     * @return new long[] instance representing this byte array
     * @throws IllegalArgumentException if internal byte length mod 8 != 0
     */
    public long[] toLongArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 4 byte / 32 bit long, return the
     * representation for a Java float value. The output is dependent on the set {@link #byteOrder()}.
     *
     * @return the float representation
     * @throws IllegalArgumentException if byte array has length not equal to 4
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public float toFloat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the internal byte array to a float array, that is, every 4 bytes will be packed into a single float.
     * <p>
     * E.g. 4 bytes will be packed to a length 1 float array:
     * <pre>
     *  [b1, b2, b3, b4] = [float1]
     * </pre>
     * <p>
     * This conversion respects the internal byte order. Will only work if all bytes can be directly mapped to float,
     * which means the byte array length must be dividable by 4 without rest.
     *
     * @return new float[] instance representing this byte array
     * @throws IllegalArgumentException if internal byte length mod 4 != 0
     */
    public float[] toFloatArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the underlying byte array is exactly 8 byte / 64 bit long, return the
     * representation for a Java double value. The output is dependent on the set {@link #byteOrder()}.
     *
     * @return the double representation
     * @throws IllegalArgumentException if byte array has length not equal to 8
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Primitive Types</a>
     */
    public double toDouble() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the internal byte array to a double array, that is, every 8 bytes will be packed into a single double.
     * <p>
     * E.g. 8 bytes will be packed to a length 1 double array:
     * <pre>
     *  [b1, b2, b3, b4, b5, b6, b7, b8] = [double1]
     * </pre>
     * <p>
     * This conversion respects the internal byte order. Will only work if all bytes can be directly mapped to double,
     * which means the byte array length must be dividable by 8 without rest.
     *
     * @return new double[] instance representing this byte array
     * @throws IllegalArgumentException if internal byte length mod 8 != 0
     */
    public double[] toDoubleArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the internal byte array to a short array, that is, every 2 bytes will be packed into a single short.
     * <p>
     * E.g. 2 bytes will be packed to a length 1 short array:
     * <pre>
     *  [b1, b2] = [short1]
     * </pre>
     * <p>
     * This conversion respects the internal byte order. Will only work if all bytes can be directly mapped to short,
     * which means the byte array length must be dividable by 2 without rest.
     *
     * @return new short[] instance representing this byte array
     * @throws IllegalArgumentException if internal byte length mod 2 != 0
     */
    public short[] toShortArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes the internal byte array to UTF-8 char array.
     * This implementation will not internally create a {@link String}.
     *
     * @return char array
     */
    public char[] toCharArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes the internal byte array with given charset to a char array.
     * This implementation will not internally create a {@link String}.
     *
     * @param charset to use for decoding
     * @return char array
     */
    public char[] toCharArray(Charset charset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares this bytes instance to another.
     * <p>
     * Two byte bytes are compared by comparing their sequences of
     * remaining elements lexicographically, without regard to the starting
     * position of each sequence within its corresponding buffer.
     * Pairs of {@code byte} elements are compared as if by invoking
     * {@link Byte#compare(byte, byte)}.
     * <p>
     * Uses {@link ByteBuffer#compareTo(ByteBuffer)} internally.
     *
     * @return A negative integer, zero, or a positive integer as this buffer
     * is less than, equal to, or greater than the given buffer
     */
    @Override
    public int compareTo(Bytes o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if this instance is equal to given other instance o
     *
     * @param o other instance
     * @return if the instance are equal
     */
    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares the inner array with given array
     *
     * @param anotherArray to compare with
     * @return true if {@link Arrays#equals(byte[], byte[])} returns true on given and internal array
     */
    public boolean equals(byte[] anotherArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares the inner array with given array. The comparison is done in constant time, therefore
     * will not break on the first mismatch. This method is useful to prevent some side-channel attacks,
     * but is slower on average.
     * <p>
     * This implementation uses the algorithm suggested in <a href="https://codahale.com/a-lesson-in-timing-attacks/">a-lesson-in-timing-attacks</a>
     *
     * @param anotherArray to compare with
     * @return true if {@link Arrays#equals(byte[], byte[])} returns true on given and internal array
     */
    public boolean equalsConstantTime(byte[] anotherArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares the inner array with given array.
     * Note: a <code>null</code> Byte will not be equal to a <code>0</code> byte
     *
     * @param anotherArray to compare with
     * @return true if both array have same length and every byte element is the same
     */
    public boolean equals(Byte[] anotherArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares the inner array with the inner array of given ByteBuffer.
     * Will check for internal array and byte order.
     *
     * @param buffer to compare with
     * @return true if both array have same length and every byte element is the same
     */
    public boolean equals(ByteBuffer buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks only for internal array content
     *
     * @param other to compare to
     * @return true if the internal array are equals (see {@link Arrays#equals(byte[], byte[])})
     */
    public boolean equalsContent(Bytes other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A constant length output toString() implementation, which only shows the byte length and at most 8 bytes preview in hex
     * representation.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Iterator<Byte> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Internal factory for {@link Bytes} instances
     */
    private static class Factory implements BytesFactory {

        @Override
        public Bytes wrap(byte[] array, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final long serialVersionUID = 1L;
}

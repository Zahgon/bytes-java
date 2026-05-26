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

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Interface for byte-to-text-encodings
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary-to-text_encoding">Binary To Text Encoding</a>
 */
public interface BinaryToTextEncoding {

    /**
     * Interface for encoding bytes
     */
    interface Encoder {

        /**
         * Encodes given array with given byte order to a string
         *
         * @param array     to encode
         * @param byteOrder the array is in
         * @return encoded string
         */
        String encode(byte[] array, ByteOrder byteOrder);
    }

    /**
     * Interface for decoding encoded strings
     */
    interface Decoder {

        /**
         * Decodes given encoded string
         *
         * @param encoded string
         * @return byte array represented by given encoded string
         */
        byte[] decode(CharSequence encoded);
    }

    /**
     * Unifies both interfaces {@link Encoder} and {@link Decoder}
     */
    interface EncoderDecoder extends Encoder, Decoder {
    }

    /**
     * Hex or Base16
     */
    class Hex implements EncoderDecoder {

        private static final char[] LOOKUP_TABLE_LOWER = new char[] { 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66 };

        private static final char[] LOOKUP_TABLE_UPPER = new char[] { 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 };

        private final boolean upperCase;

        public Hex() {
            this(true);
        }

        public Hex(boolean upperCase) {
            this.upperCase = upperCase;
        }

        @Override
        public String encode(byte[] byteArray, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public byte[] decode(CharSequence hexString) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Simple Base64 encoder
     */
    class Base64Encoding implements EncoderDecoder {

        private final boolean urlSafe;

        private final boolean padding;

        Base64Encoding() {
            this(false, true);
        }

        Base64Encoding(boolean urlSafe, boolean padding) {
            this.urlSafe = urlSafe;
            this.padding = padding;
        }

        @Override
        public String encode(byte[] array, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public byte[] decode(CharSequence encoded) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Simple radix encoder which internally uses {@link BigInteger#toString(int)}
     */
    class BaseRadixNumber implements EncoderDecoder {

        private final int radix;

        BaseRadixNumber(int radix) {
            if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
                throw new IllegalArgumentException("supported radix is between " + Character.MIN_RADIX + " and " + Character.MAX_RADIX);
            }
            this.radix = radix;
        }

        @Override
        public String encode(byte[] array, ByteOrder byteOrder) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public byte[] decode(CharSequence encoded) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

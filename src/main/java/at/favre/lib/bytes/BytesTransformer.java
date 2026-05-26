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

import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Interface for transforming {@link Bytes}
 */
public interface BytesTransformer {

    /**
     * Transform given victim in place, overwriting its internal byte array
     *
     * @param currentArray to preform the transformation on
     * @param inPlace      perform the operations directly on the victim's byte array to omit copying of the internal array
     * @return resulting bytes (either the overwritten instance or a new one)
     */
    byte[] transform(byte[] currentArray, boolean inPlace);

    /**
     * If this transformer supports transformation without creation a new array
     *
     * @return true if supported
     */
    boolean supportInPlaceTransformation();

    /**
     * Simple transformer for bitwise operations on {@link Bytes} instances
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Bitwise_operators">Bitwise operation</a>
     */
    final class BitWiseOperatorTransformer implements BytesTransformer {

        public enum Mode {

            AND, OR, XOR
        }

        private final byte[] secondArray;

        private final Mode mode;

        BitWiseOperatorTransformer(byte[] secondArray, Mode mode) {
            this.secondArray = Objects.requireNonNull(secondArray, "the second byte array must not be null");
            this.mode = Objects.requireNonNull(mode, "passed bitwise mode must not be null");
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Simple transformer for bitwise unary negation on {@link Bytes} instances
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#NOT">Bitwise operators: NOT</a>
     */
    final class NegateTransformer implements BytesTransformer {

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Simple transformer for bit shifting {@link Bytes} instances
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Bit_shifts">Bit shifts</a>
     */
    final class ShiftTransformer implements BytesTransformer {

        public enum Type {

            LEFT_SHIFT, RIGHT_SHIFT
        }

        private final int shiftCount;

        private final Type type;

        private final ByteOrder byteOrder;

        ShiftTransformer(int shiftCount, Type type, ByteOrder byteOrder) {
            this.shiftCount = shiftCount;
            this.type = Objects.requireNonNull(type, "passed shift type must not be null");
            this.byteOrder = Objects.requireNonNull(byteOrder, "passed byteOrder type must not be null");
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Simple transformer for bitwise operations on {@link Bytes} instances
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Bitwise_operators">Bitwise operation</a>
     */
    final class ConcatTransformer implements BytesTransformer {

        private final byte[] secondArray;

        ConcatTransformer(byte[] secondArrays) {
            this.secondArray = Objects.requireNonNull(secondArrays, "the second byte array must not be null");
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Reverses the internal byte array
     */
    final class ReverseTransformer implements BytesTransformer {

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Creates a new instance with a copy of the internal byte array and all other attributes.
     */
    final class CopyTransformer implements BytesTransformer {

        final int offset;

        final int length;

        CopyTransformer(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Copies the specified array, truncating or padding with zeros (if necessary)
     * so the copy has the specified length.  For all indices that are
     * valid in both the original array and the copy, the two arrays will
     * contain identical values.  For any indices that are valid in the
     * copy but not the original, the copy will contain {@code (byte)0}.
     * <p>
     * If the internal array will be increased, zero bytes will be added on the left,
     * keeping the value the same.
     */
    final class ResizeTransformer implements BytesTransformer {

        public enum Mode {

            RESIZE_KEEP_FROM_ZERO_INDEX, RESIZE_KEEP_FROM_MAX_LENGTH
        }

        private final int newSize;

        private final Mode mode;

        ResizeTransformer(int newSize, Mode mode) {
            this.newSize = newSize;
            this.mode = mode;
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Switches bits on specific position of an array
     */
    class BitSwitchTransformer implements BytesTransformer {

        private final int position;

        private final Boolean newBitValue;

        BitSwitchTransformer(int position, Boolean newBitValue) {
            this.position = position;
            this.newBitValue = newBitValue;
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Converts to hash
     */
    class MessageDigestTransformer implements BytesTransformer {

        static final String ALGORITHM_MD5 = "MD5";

        static final String ALGORITHM_SHA_1 = "SHA-1";

        static final String ALGORITHM_SHA_256 = "SHA-256";

        private final MessageDigest messageDigest;

        MessageDigestTransformer(String digestName) {
            try {
                this.messageDigest = MessageDigest.getInstance(digestName);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException("could not get message digest algorithm " + digestName, e);
            }
        }

        @Override
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean supportInPlaceTransformation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

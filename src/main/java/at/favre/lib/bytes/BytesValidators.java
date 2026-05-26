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

import java.util.Arrays;
import java.util.Collections;

/**
 * Util and easy access for {@link BytesValidators}
 */
@SuppressWarnings("WeakerAccess")
public final class BytesValidators {

    private BytesValidators() {
    }

    /**
     * Checks the length of a byte array
     *
     * @param byteLength to check against
     * @return validator that returns true if longer or equal to given value
     */
    public static BytesValidator atLeast(int byteLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks the length of a byte array
     *
     * @param byteLength to check against
     * @return validator that returns true if smaller or equal to given value
     */
    public static BytesValidator atMost(int byteLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks the length of a byte array
     *
     * @param byteLength to check against
     * @return validator that returns true if equal to given value
     */
    public static BytesValidator exactLength(int byteLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks individual byte content
     *
     * @param refByte to check against
     * @return validator that returns true if array only consists of refByte
     */
    public static BytesValidator onlyOf(byte refByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks individual byte content
     *
     * @param refByte to check against
     * @return validator that returns true  if array has at least one byte that is not refByte
     */
    public static BytesValidator notOnlyOf(byte refByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the internal byte array starts with given bytes
     *
     * @param startsWithBytes the supposed prefix
     * @return validator that returns true all startsWithBytes match the first bytes in the internal array
     */
    public static BytesValidator startsWith(byte... startsWithBytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the internal byte array ends with given bytes
     *
     * @param endsWithBytes the supposed postfix
     * @return validator that returns true all startsWithBytes match the first bytes in the internal array
     */
    public static BytesValidator endsWith(byte... endsWithBytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks individual byte content
     *
     * @param refByte to check against
     * @return validator that returns true if array has no value refByte
     */
    public static BytesValidator noneOf(byte refByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This will execute all passed validators and returns true if at least one returns true (i.e. OR concatenation)
     *
     * @param validators at least one validator must be passed
     * @return validator that returns true if at least one validator returns true
     */
    public static BytesValidator or(BytesValidator... validators) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This will execute all passed validators and returns true if all return true (i.e. AND concatenation)
     *
     * @param validators at least one validator must be passed
     * @return validator that returns true if all return true
     */
    public static BytesValidator and(BytesValidator... validators) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This will negate the result of the passed validator
     *
     * @param validator to negate
     * @return negated result
     */
    public static BytesValidator not(BytesValidator validator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

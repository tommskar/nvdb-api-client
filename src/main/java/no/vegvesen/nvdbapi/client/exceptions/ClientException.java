/*
 * Copyright (c) 2015-2016, Statens vegvesen
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package no.vegvesen.nvdbapi.client.exceptions;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ClientException extends RuntimeException {
    private final List<ApiError> errors;
    private final int statusCode;

    public ClientException(int statusCode, List<ApiError> errors, Throwable cause) {
        super(cause);
        this.statusCode = Objects.requireNonNull(statusCode);
        this.errors = Objects.requireNonNull(errors);
    }

    public ClientException(int statusCode, List<ApiError> errors) {
        this(statusCode, errors, null);
    }

    public List<ApiError> getErrors() {
        return errors;
    }

    public Stream<ApiError> errors() {
        return errors.stream();
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HTTP error ").append(statusCode).append(":\n");
        errors().forEach(e -> sb.append(String.format("Error %d: %s\n", e.getErrorCode(), e.getErrorMessage())));
        return sb.toString();
    }
}

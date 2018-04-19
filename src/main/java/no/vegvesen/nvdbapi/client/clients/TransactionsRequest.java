/*
 * Copyright (c) 2015-2018, Statens vegvesen
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package no.vegvesen.nvdbapi.client.clients;

import no.vegvesen.nvdbapi.client.model.Page;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class TransactionsRequest {

    public static final TransactionsRequest DEFAULT = new TransactionsRequest.Builder().build();

    private final Page page;
    private final List<Integer> ider;
    private final LocalDateTime from;
    private final LocalDateTime to;

    private TransactionsRequest(Builder b){
        this.page = b.page;
        this.ider = b.ider;
        this.from = b.from;
        this.to = b.to;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Page getPage() {
        return page;
    }

    public List<Integer> getIder() {
        return ider;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static class Builder{

        private Page page = Page.count(1000);
        private List<Integer> ider = Collections.emptyList();
        private LocalDateTime from = null;
        private LocalDateTime to = null;

        public TransactionsRequest build() {
            return new TransactionsRequest(this);
        }

        public Builder withPage(Page page){
            this.page = page;
            return this;
        }

        public Builder withIder(List<Integer> ider){
            this.ider = ider;
            return this;
        }

        public Builder withFrom(LocalDateTime from){
            this.from = from;
            return this;
        }

        public Builder withTo(LocalDateTime to){
            this.to = to;
            return this;
        }
    }


}

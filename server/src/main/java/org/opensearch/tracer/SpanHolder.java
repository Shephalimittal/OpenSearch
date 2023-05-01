/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.tracer;

import java.util.concurrent.atomic.AtomicReference;

public class SpanHolder {

    private final AtomicReference<Span> span = new AtomicReference<>();

    public SpanHolder(SpanHolder spanHolder) {
        this.span.getAndSet(spanHolder.span.get());
    }

    public SpanHolder(Span span) {
        this.span.getAndSet(span);
    }

    public Span getSpan() {
        return span.get();
    }

    public void setSpan(Span span) {
        this.span.getAndSet(span);
    }
}

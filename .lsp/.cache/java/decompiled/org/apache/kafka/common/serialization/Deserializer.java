/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  org.apache.kafka.common.header.Headers
 */
package org.apache.kafka.common.serialization;

import java.io.Closeable;
import java.util.Map;
import org.apache.kafka.common.header.Headers;

public interface Deserializer<T>
extends Closeable {
    default public void configure(Map<String, ?> configs, boolean isKey) {
    }

    public T deserialize(String var1, byte[] var2);

    default public T deserialize(String topic, Headers headers, byte[] data) {
        return this.deserialize(topic, data);
    }

    default public void close() {
    }
}

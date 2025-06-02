package org.wheat.tliaswebmanagement;

import org.junit.jupiter.api.Test;

import static java.util.UUID.randomUUID;

public class UUIDTest {
    @Test
    public void testUUID() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(randomUUID().toString());
        }
    }
}

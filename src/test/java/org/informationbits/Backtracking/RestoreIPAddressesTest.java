package org.informationbits.Backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RestoreIPAddressesTest {

    @Test
    void getIpAddresses() {
        List<String> actual = RestoreIPAddressesWithMemory.getIpAddresses("201023");
        List<String> expected = Arrays.asList("2.0.10.23", "2.0.102.3", "20.1.0.23", "20.10.2.3", "201.0.2.3");
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }
}
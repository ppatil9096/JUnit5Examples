package com.patjavahere.junit5.examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagDemoTest {
    @Test
    @Tag("DEV")
    @Tag("PROD")
    public void testCaseRunInBothEnv() {
    }

    @Test
    @Tag("DEV")
    void testCaseRunInDevEnv() {
    }
}

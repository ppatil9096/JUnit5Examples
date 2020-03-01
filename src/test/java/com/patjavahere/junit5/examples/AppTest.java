package com.patjavahere.junit5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.runner.RunWith;

import java.util.function.Supplier;



/**
 * Unit test for simple App.
 *
 * @author pravin
 * @Date 20 Feb, 2020
 */
@RunWith(JUnitPlatform.class)
//@IncludeClassNamePatterns({"^.*ATests?$"})
//@ExcludeClassNamePatterns({"^.*ATests?$"})
public class AppTest {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    @Test
    void testSum() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4, App.sum(2, 2));
    }

    @Disabled
    @Test
    void testSumDisabled() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(6, App.sum(2, 4));
    }

    @Test
    public void testSupplierCaseWithAssertions() {
        Supplier<String> messageSupplier = () -> "App.sum(2, 2) test failed";
        Assertions.assertEquals(4, App.sum(3, 2), messageSupplier);
    }


    @Test
    void testOnDev() {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
    }

    @Test
    void testOnProd() {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
    }

    @DisplayName("Sum test")
    @RepeatedTest(3)
    void testSumRepeated(RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        Assertions.assertEquals(2, App.sum(1, 1), "1 + 1 should equal 2");
    }

    @Test
    void testExpectedException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @Test
    void testExpectedExceptionWithSuperType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @Test
    void testExpectedExceptionFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("1");
        });
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll executed");
    }
}

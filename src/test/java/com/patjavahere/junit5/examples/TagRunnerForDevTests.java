package com.patjavahere.junit5.examples;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.patjavahere.junit5.examples")
@IncludeTags("DEV")
//@ExcludeTags("PROD")
public class TagRunnerForDevTests {
}
package com.soda.test;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntTest {

    @Test
    public void testAntPattern() {
        PathMatcher pathMatcher = new AntPathMatcher(".");
        System.out.println(pathMatcher.match("localhost", "localhost"));


    }
}

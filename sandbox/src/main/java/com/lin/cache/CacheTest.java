package com.lin.cache;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;

import java.util.concurrent.TimeUnit;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class CacheTest {
    private  Cache<String, Object> cache;

    private void testIt(){

        this.cache = Cache2kBuilder.of(String.class, Object.class)
                          .entryCapacity(100l)
                          .expireAfterWrite(1000, TimeUnit.SECONDS)
                          .build();

        cache.clear();
        cache.computeIfAbsent("Li", value->createNewValue());

        System.out.println(cache.get("Li"));
    }

    private String createNewValue(){
        return "Hello World";
    }

    public static void main(String[] args) {
        CacheTest test = new CacheTest();
        test.testIt();
    }

}

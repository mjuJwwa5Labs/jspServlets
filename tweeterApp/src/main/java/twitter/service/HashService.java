package twitter.service;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.function.Function;

public class HashService implements Function<String,String> {

    @Override
    public String apply(String stringGiven) {
        return DigestUtils.md5Hex(stringGiven).toUpperCase();
    }
}

package com.xun.tigablog.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 明文加密
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}

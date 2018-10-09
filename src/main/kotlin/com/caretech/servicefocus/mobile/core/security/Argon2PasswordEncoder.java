package com.caretech.servicefocus.mobile.core.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


public class Argon2PasswordEncoder implements PasswordEncoder {


    private static final Argon2 ARGON2 = Argon2Factory.create();

    private static final int ITERATIONS = 2;
    private static final int MEMORY= 65536;
    private static final int PARALLELISM = 1;

    @Override
    public String encode(CharSequence charSequence) {
        return ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return ARGON2.verify(s, charSequence.toString());
    }
}

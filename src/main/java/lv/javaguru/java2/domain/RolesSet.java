package lv.javaguru.java2.domain;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RolesSet {
    public final static Role USER =  new Role(1L, "ROLE_USER");
    public final static Role ADMIN =  new Role(2L, "ROLE_ADMIN");

    private final static Set<Role> ROLES = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(
                    USER,
                    ADMIN
              )));

    public static Set<Role> getROLES() {
        return ROLES;
    }
}

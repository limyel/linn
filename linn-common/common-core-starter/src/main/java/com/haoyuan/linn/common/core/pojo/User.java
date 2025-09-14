package com.haoyuan.linn.common.core.pojo;

import java.util.Set;

public interface User<T> {

    T getId();

    String getUsername();

    String getPassword();

    Set<String> getPerms();

    Set<String> getRoles();

}

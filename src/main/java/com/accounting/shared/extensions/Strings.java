package com.accounting.shared.extensions;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public class Strings {
    public String Summary(@This String s) {
        if (s == null) return "";
        if (s.length() <= 10) return s;
        return s.substring(10);
    }
}

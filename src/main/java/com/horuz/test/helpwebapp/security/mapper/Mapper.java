package com.horuz.test.helpwebapp.security.mapper;

public interface Mapper<D, S> {
    D map(S source);
}

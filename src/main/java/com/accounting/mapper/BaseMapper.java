package com.accounting.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BaseMapper {

    public ModelMapper modelMapper;

    public BaseMapper() {
        this.modelMapper = new ModelMapper();
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

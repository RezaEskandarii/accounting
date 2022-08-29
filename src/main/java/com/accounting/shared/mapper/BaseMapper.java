package com.accounting.shared.mapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BaseMapper {

    public ModelMapper modelMapper;

    public BaseMapper() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    }

    public <S, T> List<T> mapToList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

}

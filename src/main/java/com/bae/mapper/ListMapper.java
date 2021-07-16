package com.bae.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * date 2021-03-11 14:08
 *
 * @author Phạm Ngọc Thắng
 */
public class ListMapper {
    @Autowired
    private ModelMapper modelMapper;

    /**
     * thực hiện mapper giữa 2 List
     * @param source
     * @param targetClass
     * @param <S>
     * @param <T>
     * @return
     */
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

package com.bae.config;

import com.bae.mapper.ListMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;

/**
 * date 2021-03-11 14:05
 *
 * @author Phạm Ngọc Thắng
 */
public class AppConfig {

    @Bean
    ModelMapper getmodelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //chi lấy thông tin của một class cần mapper
        //modelMapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
        return modelMapper;
    }

    @Bean
    ListMapper getListMapper() {
        return new ListMapper();
    }
}

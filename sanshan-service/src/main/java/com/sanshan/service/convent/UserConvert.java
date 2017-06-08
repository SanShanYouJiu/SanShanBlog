package com.sanshan.service.convent;

import com.github.pagehelper.PageInfo;
import com.sanshan.pojo.dto.MarkDownBlogDTO;
import com.sanshan.pojo.dto.UserDTO;
import com.sanshan.pojo.entity.MarkDownBlogDO;
import com.sanshan.pojo.entity.UserDO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Objects;

public class UserConvert {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDTO doToDto(UserDO userDO) {
        if (Objects.isNull(userDO)){
            return null;
        }
        return modelMapper.map(userDO,UserDTO.class);
    }

    public static List<UserDTO> doToDtoList(List<UserDO> userDOS) {
        return modelMapper.map(userDOS,new TypeToken<List<UserDTO>>(){}.getType());
    }


    public static PageInfo<UserDTO> doToDtoPage(PageInfo<UserDO> userDOPageInfo) {
        List<UserDO> list = userDOPageInfo.getList();
        List<UserDTO> userDTOS = UserConvert.doToDtoList(list);
        return new PageInfo<UserDTO>(userDTOS);
    }
}
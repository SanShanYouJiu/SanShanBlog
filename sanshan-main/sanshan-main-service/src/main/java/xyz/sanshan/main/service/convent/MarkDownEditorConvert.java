package xyz.sanshan.main.service.convent;


import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import xyz.sanshan.main.pojo.dto.MarkDownBlogDTO;
import xyz.sanshan.main.pojo.entity.MarkDownBlogDO;

import java.util.List;
import java.util.Objects;

public class MarkDownEditorConvert {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static MarkDownBlogDTO doToDto(MarkDownBlogDO markDownBlogDO) {
        if (Objects.isNull(markDownBlogDO)) {
            return null;
        }
        return MODEL_MAPPER.map(markDownBlogDO, MarkDownBlogDTO.class);
     }


    public static List<MarkDownBlogDTO> doToDtoList(List<MarkDownBlogDO> markDownBlogDOS) {
        return MODEL_MAPPER.map(markDownBlogDOS,new TypeToken<List<MarkDownBlogDTO>>(){}.getType());
    }


    public static PageInfo<MarkDownBlogDTO> doToDtoPage(PageInfo<MarkDownBlogDO> markDownBlogDOPageInfo) {
        List<MarkDownBlogDO> list = markDownBlogDOPageInfo.getList();
        List<MarkDownBlogDTO> markDownBlogDTOS = MarkDownEditorConvert.doToDtoList(list);
        return new PageInfo<MarkDownBlogDTO>(markDownBlogDTOS);
    }




}

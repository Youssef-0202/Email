package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.ws.dto.commun.CategoryEmailDto;

@Component
public class CategoryEmailConverter extends AbstractConverter<CategoryEmail, CategoryEmailDto> {


    public  CategoryEmailConverter() {
        super(CategoryEmail.class, CategoryEmailDto.class);
    }

    @Override
    public CategoryEmail toItem(CategoryEmailDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategoryEmail item = new CategoryEmail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public CategoryEmailDto toDto(CategoryEmail item) {
        if (item == null) {
            return null;
        } else {
            CategoryEmailDto dto = new CategoryEmailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}

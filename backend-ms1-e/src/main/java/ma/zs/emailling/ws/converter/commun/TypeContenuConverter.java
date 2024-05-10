package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.ws.dto.commun.TypeContenuDto;

@Component
public class TypeContenuConverter extends AbstractConverter<TypeContenu, TypeContenuDto> {


    public  TypeContenuConverter() {
        super(TypeContenu.class, TypeContenuDto.class);
    }

    @Override
    public TypeContenu toItem(TypeContenuDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeContenu item = new TypeContenu();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public TypeContenuDto toDto(TypeContenu item) {
        if (item == null) {
            return null;
        } else {
            TypeContenuDto dto = new TypeContenuDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}

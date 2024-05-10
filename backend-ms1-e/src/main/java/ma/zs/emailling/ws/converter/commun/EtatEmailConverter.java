package  ma.zs.emailling.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.emailling.zynerator.util.StringUtil;
import ma.zs.emailling.zynerator.converter.AbstractConverter;
import ma.zs.emailling.zynerator.util.DateUtil;
import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.ws.dto.commun.EtatEmailDto;

@Component
public class EtatEmailConverter extends AbstractConverter<EtatEmail, EtatEmailDto> {


    public  EtatEmailConverter() {
        super(EtatEmail.class, EtatEmailDto.class);
    }

    @Override
    public EtatEmail toItem(EtatEmailDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatEmail item = new EtatEmail();
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
    public EtatEmailDto toDto(EtatEmail item) {
        if (item == null) {
            return null;
        } else {
            EtatEmailDto dto = new EtatEmailDto();
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

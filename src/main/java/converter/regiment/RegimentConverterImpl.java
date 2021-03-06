package converter.regiment;

import dto.RegimentDto;
import entity.*;
import org.springframework.stereotype.Component;

@Component
public class RegimentConverterImpl implements RegimentConverter {



    @Override
    public RegimentDto convertRegimentToDto(Regiment regiment) {
        RegimentDto regimentDto = new RegimentDto();
        regimentDto.setId(regiment.getId());
        regimentDto.setCode(regiment.getCode());
        regimentDto.setIntelligence(regiment.getIntelligence());
        regimentDto.setStamina(regiment.getStamina());
        regimentDto.setStrength(regiment.getStrength());
        regimentDto.setShooting(regiment.getShooting());
        regimentDto.setSupplyId(regiment.getSupply().getId());
        regimentDto.setTypeId(regiment.getType().getId());
        regimentDto.setRequirementId(regiment.getRequirement().getId());
        regimentDto.setMedSkills(regiment.getMedSkills());
        regimentDto.setTypeName(regiment.getType().getTypeName());

        return regimentDto;
    }




}

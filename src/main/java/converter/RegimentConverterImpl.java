package converter;

import dto.RegimentDto;
import dto.UserDto;
import entity.Regiment;
import entity.Role;
import entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegimentConverterImpl implements RegimentConverter {

    @Override
    public UserDto convertUserToDto(User user){
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        List<Role> roles = user.getRoles();
        for(Role role:roles)
            userDto.setRoles(userDto.getRoles()+" "+role.getRoleName());
        return userDto;
    }

    @Override
    public RegimentDto convertRegimentToDto(Regiment regiment) {
        RegimentDto regimentDto = new RegimentDto();
        regimentDto.setId(regiment.getId());
        regimentDto.setCode(regiment.getCode());
        regimentDto.setIntelligence(regiment.getIntelligence());
        regimentDto.setStamina(regiment.getStamina());
        regimentDto.setStrength(regiment.getStrength());
        regimentDto.setStrength(regiment.getShooting());
        regimentDto.setSupplyId(regiment.getSupply().getId());
        regimentDto.setTypeId(regiment.getType().getId());
        regimentDto.setMedSkills(regiment.getMedSkills());
        regimentDto.setTypeName(regiment.getType().getTypeName());

        return regimentDto;
    }
}

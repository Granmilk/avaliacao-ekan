package br.gov.sp.iamspe.ekan.domain.dto;

import br.gov.sp.iamspe.ekan.domain.UserEntity;
import br.gov.sp.iamspe.ekan.domain.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private Date birthDate;
    private UserType userType;
    private List<TelephoneDTO> telephoneList;

    public UserDTO(UserEntity userEntity) {
        userId = userEntity.getUserId();
        name = userEntity.getUserName();
        birthDate = userEntity.getBirthDate();
        userType = userEntity.getUserType();
        telephoneList = new ArrayList<>();
        userEntity.getTelephoneList().forEach(telephoneEntity -> {
            telephoneList.add(TelephoneDTO.builder()
                    .telephoneId(telephoneEntity.getTelephoneId())
                    .ddd(telephoneEntity.getDdd())
                    .number(telephoneEntity.getNumber())
                    .build());
        });
    }
}

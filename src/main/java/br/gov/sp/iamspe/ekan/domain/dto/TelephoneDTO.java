package br.gov.sp.iamspe.ekan.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneDTO {

    private Long telephoneId;
    private Integer ddd;
    private Integer number;
}

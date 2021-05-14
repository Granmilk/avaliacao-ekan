package br.gov.sp.iamspe.ekan.domain;

import br.gov.sp.iamspe.ekan.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column
    private Long userId;

    @Column
    private String userName;

    @Column
    private Date birthDate;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "userId")
    private List<TelephoneEntity> telephoneList;

}

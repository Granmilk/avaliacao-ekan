package br.gov.sp.iamspe.ekan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telephone")
public class TelephoneEntity {

    @Id
    @GeneratedValue
    @Column
    private Long telephoneId;

    @Column
    private Integer ddd;

    @Column
    private Integer number;

    @ManyToOne
    private UserEntity userId;

}

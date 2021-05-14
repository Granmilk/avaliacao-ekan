package br.gov.sp.iamspe.ekan.service;

import br.gov.sp.iamspe.ekan.domain.TelephoneEntity;
import br.gov.sp.iamspe.ekan.domain.UserEntity;
import br.gov.sp.iamspe.ekan.domain.dto.UserDTO;
import br.gov.sp.iamspe.ekan.repository.TelephoneRepository;
import br.gov.sp.iamspe.ekan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TelephoneRepository telephoneRepository;

    public UserDTO findUserById(Long userId) {
        return new UserDTO(userRepository.findById(userId).orElseThrow(() -> new NoResultException("User doesn't exist")));
    }

    public void insertUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(UserEntity.builder().userName(userDTO.getName()).userType(userDTO.getUserType()).birthDate(userDTO.getBirthDate()).build());
        userDTO.getTelephoneList().forEach(telephoneDTO -> telephoneRepository.save(TelephoneEntity.builder().userId(userEntity).ddd(telephoneDTO.getDdd()).number(telephoneDTO.getNumber()).build()));
    }

    public List<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepository.findAll().forEach(userEntity -> userDTOList.add(new UserDTO(userEntity)));
        return userDTOList;

    }
}

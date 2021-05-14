package br.gov.sp.iamspe.ekan.controller;

import br.gov.sp.iamspe.ekan.domain.dto.UserDTO;
import br.gov.sp.iamspe.ekan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserDtoById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUserAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity saveUserDto(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return ResponseEntity.ok().build();
    }

}

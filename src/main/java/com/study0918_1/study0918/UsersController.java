package com.study0918_1.study0918;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({"/users","/users/"})
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> getUsersList(){
        List<UsersResponseDTO> usersResponseDTOs;
        usersResponseDTOs = usersService.getUsersList()
            .stream()
            .map(users -> new UsersResponseDTO(users.getUsername(), users.getPassword(), users.getEmail()))
            .collect(Collectors.toList());

        if(usersResponseDTOs.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(usersResponseDTOs);
    }


}

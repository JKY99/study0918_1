package com.study0918_1.study0918;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository userrRepository;

    public List<Users> getUsersList(){
        List<Users> usersList = userrRepository.findAll();

        return usersList;
    }
}

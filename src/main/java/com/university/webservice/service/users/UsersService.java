package com.university.webservice.service.users;

import com.university.webservice.domain.users.UsersRepository;
import com.university.webservice.dto.users.UsersMainResponseDto;
import com.university.webservice.dto.users.UsersSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto dto){
        return usersRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<UsersMainResponseDto> findAllDesc(String userId) {
        return usersRepository.findAllDesc(userId)
                .map(UsersMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
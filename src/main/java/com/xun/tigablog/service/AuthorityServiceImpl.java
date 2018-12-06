package com.xun.tigablog.service;

import com.xun.tigablog.domain.Authority;
import com.xun.tigablog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authority 服务.
 *
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }

}

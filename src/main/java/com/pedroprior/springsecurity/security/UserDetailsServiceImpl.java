package com.pedroprior.springsecurity.security;

import com.pedroprior.springsecurity.entities.AdminModel;
import com.pedroprior.springsecurity.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    final AdminRepository adminRepository;

    public UserDetailsServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Encontrar o usuário <-

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminModel adminModel = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(adminModel.getUsername(),
                adminModel.getPassword(),
                true,
                true,
                true,
                true, adminModel.getAuthorities());
    }


}

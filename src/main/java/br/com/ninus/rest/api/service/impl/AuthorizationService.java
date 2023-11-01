package br.com.ninus.rest.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ninus.rest.api.repository.ClientRepository;

public class AuthorizationService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var opt = clientRepository.getClientByEmail(email);
        if(!opt.isPresent()) { 
            throw new UsernameNotFoundException("conta inexistente.");
        }
        return opt.get();
    }
    
}

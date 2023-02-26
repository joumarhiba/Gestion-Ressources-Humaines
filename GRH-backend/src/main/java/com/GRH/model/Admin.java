package com.GRH.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity

public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "admin")
    private List<Formation> formations;

    @OneToMany(mappedBy = "admin")
    private List<Recruteur> recruteurs;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(getRole().name());
//        return Collections.singletonList(simpleGrantedAuthority);
//    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}

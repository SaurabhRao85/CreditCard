package com.axis.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final int age;
    private final long phoneNumber;
    private final String role;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final int pincode;
    private final String password;
    
    private final boolean enabled;
	
	public JwtUser(Long id, String username, int age, long phoneNumber, String role, String address, String city,
			String state, String country, int pincode, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.password = password;
		this.enabled = enabled;
	}

	@JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        authorities.addAll(grantedAuthorities);
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

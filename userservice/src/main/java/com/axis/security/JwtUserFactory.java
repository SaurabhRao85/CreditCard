package com.axis.security;

import com.axis.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
        		user.getId(),
        		user.getHolderName(),
        		user.getAge(),
        		user.getPhoneNumber(),
        		user.getRole(),
        		user.getAddress(),
        		user.getCity(),
        		user.getState(),
        		user.getCountry(),
        		user.getPincode(),
        		user.getPassword(),
                user.getStatus().equals("1") ? true: false );
    }
}

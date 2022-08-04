package com.ks.fbs.dto;

import com.ks.fbs.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private  String firstName;
    private  String lastName;
    private  String username;
    private  String password;
    private  String email;
    private  String active;
    private  String role="USER";

}

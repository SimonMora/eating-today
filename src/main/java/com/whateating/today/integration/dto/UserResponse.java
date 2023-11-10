package com.whateating.today.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserResponse implements Serializable {

    private String userName;
    private String email;

}

package com.whateating.today.integration.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserRequest implements Serializable {

    @Nonnull
    private String email;
    @Nonnull
    private String userName;

}

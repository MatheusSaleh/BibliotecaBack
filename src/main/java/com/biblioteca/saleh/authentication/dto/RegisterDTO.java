package com.biblioteca.saleh.authentication.dto;

import com.biblioteca.saleh.user.enuns.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

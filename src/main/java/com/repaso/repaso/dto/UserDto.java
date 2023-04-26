package com.repaso.repaso.dto;

public class UserDto {
    private String email;
    
    private String password;

    private String nombre;

    private String username;

    public UserDto() {
    }

    public UserDto(String email, String password, String nombre, String username) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getUsername() {
        return username;
    }

    
}

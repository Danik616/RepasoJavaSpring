package com.repaso.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.repaso.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByEmail(String email);
}

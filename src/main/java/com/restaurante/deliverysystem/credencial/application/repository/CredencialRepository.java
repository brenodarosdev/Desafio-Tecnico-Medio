package com.restaurante.deliverysystem.credencial.application.repository;

import com.restaurante.deliverysystem.credencial.domain.Credencial;

public interface CredencialRepository {
    Credencial salva(Credencial novaCredencial);
    Credencial buscaCredencialPorEmail(String email);
}

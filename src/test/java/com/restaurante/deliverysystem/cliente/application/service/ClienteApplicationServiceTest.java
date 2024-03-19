package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;
import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.credencial.application.service.CredencialService;
import com.restaurante.deliverysystem.util.ClienteCreator;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteApplicationServiceTest {
    @InjectMocks
    private ClienteApplicationService clienteApplicationService;

    @Mock
    private CredencialService credencialService;
    @Mock
    private ClienteRepository clienteRepository;

    @Test
    void deveCriarNovoFuncionario() {
        //Given - Dado
        Cliente cliente = ClienteCreator.criaCliente();
        ClienteRequest clienteRequest = ClienteCreator.criaClienteRequest();
        //When - Quando
        doNothing().when(credencialService).criaNovaCredencial(clienteRequest);
        when(clienteRepository.salva(any(Cliente.class))).thenReturn(cliente);
        ClienteCriadoResponse clienteCriadoResponse = clienteApplicationService.cadastraNovoCliente(clienteRequest);
        //Then - Então
        verify(credencialService, times(1)).criaNovaCredencial(clienteRequest);
        verify(clienteRepository, times(1)).salva(any(Cliente.class));
        assertNotNull(clienteCriadoResponse);
        assertEquals(ClienteCriadoResponse.class, clienteCriadoResponse.getClass());
        assertEquals(UUID.class, clienteCriadoResponse.getIdCliente().getClass());
    }
}
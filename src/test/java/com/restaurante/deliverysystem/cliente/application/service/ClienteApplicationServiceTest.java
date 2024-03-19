package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;
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

    @Test
    void deveBuscarClientePorId() {
        //Given - Dado
        Cliente cliente = ClienteCreator.criaCliente();
        String email = cliente.getEmail();
        UUID idCliente = cliente.getIdCliente();
        //When - Quando
        when(clienteRepository.clientePorEmail(anyString())).thenReturn(cliente);
        when(clienteRepository.clientePorId(idCliente)).thenReturn(cliente);
        ClienteDetalhadoResponse clienteDetalhadoResponse = clienteApplicationService.buscaClientePorId(idCliente, email);
        //Then - Então
        verify(clienteRepository, times(1)).clientePorId(idCliente);
        assertEquals(ClienteDetalhadoResponse.class, clienteDetalhadoResponse.getClass());
        assertNotNull(clienteDetalhadoResponse);
    }
}
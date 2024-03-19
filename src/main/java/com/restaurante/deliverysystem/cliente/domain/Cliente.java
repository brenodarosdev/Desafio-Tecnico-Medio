package com.restaurante.deliverysystem.cliente.domain;

import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;
import com.restaurante.deliverysystem.handler.APIException;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Cliente")
public class Cliente {
    @Id
    private UUID idCliente;
    @Indexed(unique = true)
    @NotBlank(message = "O campo email não pode estar em branco")
    @Email(message = "Este campo deve conter um email")
    private String email;
    @NotBlank(message = "O campo nomeCompleto não pode estar em branco")
    private String nomeCompleto;
    @NotNull(message = "O campo idade não pode ser nulo")
    @Min(value = 18, message = "A idade deve ser igual ou maior que 18")
    private int idade;

    public Cliente(ClienteRequest clienteNovoRequest) {
        this.idCliente = UUID.randomUUID();
        this.email = clienteNovoRequest.getEmail();
        this.nomeCompleto = clienteNovoRequest.getNomeCompleto();
        this.idade = clienteNovoRequest.getIdade();
    }

    public void alteraCliente(ClienteRequest alteraClienteRequest) {
        this.email = alteraClienteRequest.getEmail();
        this.nomeCompleto = alteraClienteRequest.getNomeCompleto();
        this.idade = alteraClienteRequest.getIdade();
    }

    public void validaCliente(UUID idCliente) {
        if(!this.idCliente.equals(idCliente)) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Credencial de autenticação não é válida!");
        }
    }
}

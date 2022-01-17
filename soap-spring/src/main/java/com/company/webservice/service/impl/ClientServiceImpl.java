package com.company.webservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.webservice.model.Client;
import com.company.webservice.repository.ClientRepository;
import com.company.webservice.service.ClientService;
import com.company.webservice.wsdl.AddClientRequest;
import com.company.webservice.wsdl.ClientsResponse;
import com.company.webservice.wsdl.DeleteClientRequest;
import com.company.webservice.wsdl.EditClientRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private ClientRepository repository;

	@Override
    public ClientsResponse findClients() {
        ClientsResponse response = new ClientsResponse();
        response.getClients().addAll(
                ((List<Client>) repository.findAll()).stream().map(
                    (client) -> {
                        com.company.webservice.wsdl.Client clientWs = new com.company.webservice.wsdl.Client();
                        clientWs.setClientId(client.getClientId());
                        clientWs.setName(client.getName());
                        clientWs.setLastname(client.getLastName());
                        clientWs.setPhone(client.getPhone());
                        return clientWs;
                    }
                ).collect(Collectors.toList())
        );

        return response;
    }

	@Override
    public void addClient(AddClientRequest request) {
        repository.save(
            Client.builder()
                .name(request.getName())
                .lastName(request.getLastname())
                .phone(request.getPhone())
            .build()
        );
    }

    @Override
    public void editClient(EditClientRequest request) {
        com.company.webservice.wsdl.Client clientWs = request.getClient();
        repository.save(
                Client.builder()
                    .clientId(clientWs.getClientId())
                    .name(clientWs.getName())
                    .lastName(clientWs.getLastname())
                    .phone(clientWs.getPhone())
                .build()
        );
    }

    @Override
    public void deleteClient(DeleteClientRequest request) {
        repository.deleteById(request.getClientId());
    }

}

package com.company.webservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.company.webservice.enumeration.StatusEnum;
import com.company.webservice.service.ClientService;
import com.company.webservice.wsdl.AddClientRequest;
import com.company.webservice.wsdl.ClientsResponse;
import com.company.webservice.wsdl.DeleteClientRequest;
import com.company.webservice.wsdl.EditClientRequest;
import com.company.webservice.wsdl.ListClientRequest;
import com.company.webservice.wsdl.StatusResponse;

import lombok.AllArgsConstructor;

@Endpoint
@AllArgsConstructor
public class ClientsEndpoint {
    private static final String NAMESPACE_URI = "http://company.com/webservice";

    private ClientService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listClientRequest")
    @ResponsePayload
    public ClientsResponse list(@RequestPayload ListClientRequest request) {
        ClientsResponse response = service.findClients();
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClientRequest")
    @ResponsePayload
    public StatusResponse add(@RequestPayload AddClientRequest request) {
        service.addClient(request);
        StatusResponse response = new StatusResponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editClientRequest")
    @ResponsePayload
    public StatusResponse edit(@RequestPayload EditClientRequest request) {
        service.editClient(request);
        StatusResponse response = new StatusResponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClientRequest")
    @ResponsePayload
    public StatusResponse delete(@RequestPayload DeleteClientRequest request) {
        service.deleteClient(request);
        StatusResponse response = new StatusResponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

}

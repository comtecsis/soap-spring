package com.company.webservice.endpoint;

import com.company.webservice.enumeration.StatusEnum;
import com.company.webservice.wsdl.*;
import com.company.webservice.service.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class ClientsEndpoint {
    private static final String NAMESPACE_URI = "http://company.com/webservice";

    private ClientServiceImpl service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listClientRequest")
    @ResponsePayload
    public ClientsResponse list(@RequestPayload ListClientRequest request) {
        ClientsResponse response = service.findClients();
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClientRequest")
    @ResponsePayload
    public StatusReponse add(@RequestPayload AddClientRequest request) {
        service.addClient(request);
        StatusReponse response = new StatusReponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editClientRequest")
    @ResponsePayload
    public StatusReponse edit(@RequestPayload EditClientRequest request) {
        service.editClient(request);
        StatusReponse response = new StatusReponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClientRequest")
    @ResponsePayload
    public StatusReponse delete(@RequestPayload DeleteClientRequest request) {
        service.deleteClient(request);
        StatusReponse response = new StatusReponse();
        response.setStatus(StatusEnum.OK.getStatus());
        return response;
    }

}

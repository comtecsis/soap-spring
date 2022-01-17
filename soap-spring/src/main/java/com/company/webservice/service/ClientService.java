package com.company.webservice.service;

import com.company.webservice.wsdl.AddClientRequest;
import com.company.webservice.wsdl.ClientsResponse;
import com.company.webservice.wsdl.DeleteClientRequest;
import com.company.webservice.wsdl.EditClientRequest;

public interface ClientService {

	ClientsResponse findClients();

	void addClient(AddClientRequest request);

	void editClient(EditClientRequest request);

	void deleteClient(DeleteClientRequest request);

}

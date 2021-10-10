package com.superogame.supero.Controller;

import java.util.List;

import com.superogame.supero.Entity.Client;
import com.superogame.supero.service.ClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/Clients/", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAllClients() {
        return clientService.getAllClients();
    }

    
    @RequestMapping(value = "/Client/", method = RequestMethod.POST)
    public ResponseEntity<Client> CreateClient(@RequestBody Client client) {

        return clientService.createClient(client);
    }

}

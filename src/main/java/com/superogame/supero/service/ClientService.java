package com.superogame.supero.service;

import java.util.List;

import com.superogame.supero.Entity.Client;
import com.superogame.supero.Repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    
    public ResponseEntity<List<Client>> getAllClients(){
        try {
            return new ResponseEntity<List<Client>>(clientRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    
    public ResponseEntity<Client> createClient(Client client){

        try {

            Client client2 = new Client();
            client2.setName(client.getName());
            client2.setCpf(client.getCpf());


            return new ResponseEntity<Client>(clientRepository.save(client2), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    
}

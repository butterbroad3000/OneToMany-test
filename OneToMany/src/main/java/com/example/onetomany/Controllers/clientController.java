package com.example.onetomany.Controllers;

import com.example.onetomany.Entity.Client;
import com.example.onetomany.Entity.Order;
import com.example.onetomany.Repositories.clientRepo;
import com.example.onetomany.Repositories.orderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class clientController {
    @Autowired
    com.example.onetomany.Repositories.clientRepo clientRepo;
    @Autowired
    com.example.onetomany.Repositories.orderRepo orderRepo;

    @PostMapping("/createClient")
    ResponseEntity<Client> createClient(@RequestBody  Client client) {
        return new ResponseEntity<>( clientRepo.save(client),HttpStatus.OK);

    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable int id) {
        clientRepo.deleteById(id);

    }
//    @PutMapping("update/{clientid}")
//    public void updateclient(@RequestParam(value = "clientid") int clientid ,@RequestBody Client clientRequest){
//if(clientRepo.findById(clientid).isPresent()){
   // Client _client = clientRepo.findById(clientid);
//    var entity = clientRepo.findById(clientid).get();
//
//    entity.setName(clientRequest.getName());
//    entity.setName(clientRequest.getMail());
//    entity.setAdress(clientRequest.getAdress());
//    entity.setBalance(clientRequest.getBalance());
//
//    clientRepo.save(entity);}
//    }
    @PutMapping("/update/{clientid}")
    public ResponseEntity<Client> updateTutorial(@PathVariable("clientid") int clientid, @RequestBody Client client) {


            Client client1 = clientRepo.findById(clientid).get();


            client1.setName(client.getName());
            client1.setBalance(client.getBalance());
            client1.setAdress(client.getAdress());
            client1.setMail(client.getMail());
            return new ResponseEntity<>(clientRepo.save(client1), HttpStatus.OK);


    }

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientRepo.findAll();
    }
}

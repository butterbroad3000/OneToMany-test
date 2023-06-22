package com.example.onetomany.Controllers;

import com.example.onetomany.Entity.Client;
import com.example.onetomany.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class orderController {
    @Autowired
    com.example.onetomany.Repositories.clientRepo clientRepo;
    @Autowired
    com.example.onetomany.Repositories.orderRepo orderRepo;

//    @PostMapping("/createOrder/{clientid}")ResponseEntity<Order> createClient(@PathVariable int clientid  , @RequestBody Order order) {
//        if(clientRepo.findById(clientid).isPresent ()){;
//            return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);  }
//            else  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//   }

    @PostMapping("/createOrder/{clientid}")
    ResponseEntity<Order> createOrder(@PathVariable int clientid, @RequestBody Order order) {
        Optional<Client> clientOpt = clientRepo.findById(clientid);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            order.setClient(client);
            return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateOrder/{orderId}/{clientId}")
    public ResponseEntity<Order> updateOrder(@PathVariable int orderId, @PathVariable int clientId, @RequestBody Order orderRequest) {
        Order order = orderRepo.findById(orderId).get();
        // ...
        if (clientId != 0) {
            Client client = clientRepo.findById(clientId).get();
            order.setClient(client);
        }
        // ...
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }



    @DeleteMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable int orderId){
        orderRepo.deleteById(orderId);
    }
  @GetMapping("/allOrders")
        public List<Order> getAll(){
        return orderRepo.findAll();
    }
}

package com.example.onetomany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String adress;
    private int balance;
    private String mail;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)



    private List<Order> products;

}

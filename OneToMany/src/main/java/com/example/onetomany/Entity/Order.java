package com.example.onetomany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data


@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long oid;

    private String name;


    private  int amount;

    private String type;

    private int price;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client;




}

package com.nextgeneration.client;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nextgeneration.commande.Commande;

import lombok.Data;

@Data
@Entity
public class Client  {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "password is required")
    private String password;
    @Column
	private String nom;
    @NotBlank
    @Column
	private String prenom;
    @Column
	private String adresse;
    @Column
	private String telephone;
    @Column
    private Date create_At;
    @Column
    private Date update_At;
    @OneToMany
    private List<Commande> commandes;
    
    
    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.update_At = new Date();
    }
}

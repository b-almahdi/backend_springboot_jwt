package com.nextgeneration.client;

import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.nextgeneration.commande.Commande;

import lombok.Data;

@Data
@Entity
public class Client implements UserDetails  {
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "password is required")
    @JsonProperty(access = Access.WRITE_ONLY)
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

    @Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

package com.codebusters.codebusters.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdultUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(nullable = false, unique = true)
    private String email;

    private String job;

    @OneToOne
    private Wallet wallet;

    @Column(nullable = false, unique = true)
    private String cpf;


    public AdultUser() {
    }

    

    public AdultUser(Long id, User user, String email, String job, Wallet wallet, String cpf) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.job = job;
		this.wallet = wallet;
		this.cpf = cpf;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public Wallet getWallet() {
		return wallet;
	}



	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public String toString() {
		return "AdultUser [id=" + id + ", user=" + user + ", email=" + email + ", job=" + job + ", wallet=" + wallet
				+ ", cpf=" + cpf + "]";
	}



	


}

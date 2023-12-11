package hbd.entities;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "alunos")
public class Alunos {
	
    @Id
    @GeneratedValue
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "nome_aluno",nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "cidade_natal",length=50)
    private String cidade;
    
 

    public Alunos() {
    }

    public Alunos(String nome, Date data) {
        this.nome =nome;
        this.data = data;
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void print() {
        System.out.println("Item: " + this.getId() + " | " + this.getNome() + " | " + this.getData());
    }
}

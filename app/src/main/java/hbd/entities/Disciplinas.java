package hbd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "disciplinas")

public class Disciplinas {
    @Id
    
    @GeneratedValue
    @Column(name = "id_disciplina")
    private Long id;

    @Column(name = "nome_disciplina")
    private String nome_disciplina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}
    
   
}
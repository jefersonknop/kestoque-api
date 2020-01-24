package kestoque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Divisao {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Size (max = 100)
    private String nome;	
	//@NotEmpty
	@Size (max = 1024)
    private String informacoes;
	
	
	private Long inquilino_id;


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


	public String getInformacoes() {
		return informacoes;
	}


	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}


	public Long getInquilino_id() {
		return inquilino_id;
	}


	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divisao other = (Divisao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	 
	 


}


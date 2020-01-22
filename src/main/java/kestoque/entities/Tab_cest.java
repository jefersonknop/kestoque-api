package kestoque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Tab_cest {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Size (max = 7)
    private String cest;	
	//@NotEmpty
	@Size (max = 8)
    private String ncm;
	
	@Size (max = 512)
    private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Tab_cest other = (Tab_cest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	 
	 


}


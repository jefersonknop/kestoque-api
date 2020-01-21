package kestoque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Fabricante {
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	

	
	@NotEmpty
	@Size (max = 30)
	private String tipo;
		
	@NotEmpty
	@Size (max = 255)
    private String nome;
	
	@Size (max = 255)
	private String nome_fantasia;
	
	@Size (max = 255)
	private String  cpf_cnpj;
	
	@Size (max = 30)
	private String  rg_inscricao;
	
	@Size (max = 255)
	private String  logradouro;
	
	@Size (max = 20)
	private String  numero;
	
	@Size (max = 255)
	private String  complemento;
	
	@Size (max = 20)
	private String  cep;
	
	@Size (max = 100)
	private String  bairro;


	@Size (max = 100)
	private String  cidade;

	@Size (max = 2)
	private String  uf;
	
	@Size (max = 100)
    private String  pais;
    
    @Size (max = 30)
    private String  latitude;
    
    @Size (max = 30)
    private String  longitude;
    
    @Size (max = 50)
    private String  telefone;
    
    @Size (max = 50)
    private String  celular;
    
    @Size (max = 100)
    private String  email;
    
    @Size (max = 100)
    private String  site;
    
    @Size (max = 1024)
    private String  informacoes;
    
    
    private Long inquilino_id;
    
    
    

	public Long getId() {
		return id;
	}

	
	
	
	
	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getNome_fantasia() {
		return nome_fantasia;
	}





	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}





	public String getCpf_cnpj() {
		return cpf_cnpj;
	}





	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}





	public String getRg_inscricao() {
		return rg_inscricao;
	}





	public void setRg_inscricao(String rg_inscricao) {
		this.rg_inscricao = rg_inscricao;
	}





	public String getLogradouro() {
		return logradouro;
	}





	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}





	public String getNumero() {
		return numero;
	}





	public void setNumero(String numero) {
		this.numero = numero;
	}





	public String getComplemento() {
		return complemento;
	}





	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}





	public String getCep() {
		return cep;
	}





	public void setCep(String cep) {
		this.cep = cep;
	}





	public String getBairro() {
		return bairro;
	}





	public void setBairro(String bairro) {
		this.bairro = bairro;
	}





	public String getCidade() {
		return cidade;
	}





	public void setCidade(String cidade) {
		this.cidade = cidade;
	}





	public String getUf() {
		return uf;
	}





	public void setUf(String uf) {
		this.uf = uf;
	}





	public String getPais() {
		return pais;
	}





	public void setPais(String pais) {
		this.pais = pais;
	}





	public String getLatitude() {
		return latitude;
	}





	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}





	public String getLongitude() {
		return longitude;
	}





	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}





	public String getTelefone() {
		return telefone;
	}





	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}





	public String getCelular() {
		return celular;
	}





	public void setCelular(String celular) {
		this.celular = celular;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getSite() {
		return site;
	}





	public void setSite(String site) {
		this.site = site;
	}





	public String getInformacoes() {
		return informacoes;
	}





	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}





	public void setId(Long id) {
		this.id = id;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}





	public Long getInquilino_id() {
		return inquilino_id;
	}





	public void setInquilino_id(Long inquilino_id) {
		this.inquilino_id = inquilino_id;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}



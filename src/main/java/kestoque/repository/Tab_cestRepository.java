package kestoque.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import kestoque.entities.Tab_cest;






public interface Tab_cestRepository extends JpaRepository<Tab_cest, Long> {


	 
	//List<Tab_cest> findByDescricaoStartingWith(String descricao);
}


package kestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kestoque.entities.Divisao;






public interface DivisaoRepository extends JpaRepository<Divisao, Long> {

	@Query(value = "SELECT * FROM DIVISAO S WHERE S.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Divisao> findByInquilino(Long id);
	 
	
	List<Divisao> findByNomeStartingWith(String nome);
}


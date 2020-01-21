package kestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kestoque.entities.Fabricante;






public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	@Query(value = "SELECT * FROM FABRICANTE S WHERE S.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Fabricante> findByInquilino(Long id);
	 
	 
	List<Fabricante> findByNomeStartingWith(String nome);
}


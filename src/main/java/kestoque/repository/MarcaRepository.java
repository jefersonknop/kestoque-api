package kestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kestoque.entities.Marca;






public interface MarcaRepository extends JpaRepository<Marca, Long> {

	@Query(value = "SELECT * FROM MARCA S WHERE S.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Marca> findByInquilino(Long id);
	 
	 
	List<Marca> findByNomeStartingWith(String nome);
}


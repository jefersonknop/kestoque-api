package kestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kestoque.entities.Departamento;






public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	@Query(value = "SELECT * FROM DEPARTAMENTO S WHERE S.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Departamento> findByInquilino(Long id);
	 
	 
	List<Departamento> findByNomeStartingWith(String nome);
}


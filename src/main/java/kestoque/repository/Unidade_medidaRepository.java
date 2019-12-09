package kestoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kestoque.entities.Unidade_medida;





public interface Unidade_medidaRepository extends JpaRepository<Unidade_medida, Long> {

	@Query(value = "SELECT * FROM UNIDADE_MEDIDA S WHERE S.INQUILINO_ID =?1", nativeQuery = true)	  
	List<Unidade_medida> findByInquilino(Long id);
	 
	 
	List<Unidade_medida> findByDescricaoStartingWith(String descricao);
}


package kestoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kestoque.entities.ResponseModel;
import kestoque.entities.Unidade_medida;
import kestoque.repository.Unidade_medidaRepository;



@RestController
@RequestMapping("/unidades_medida")
@CrossOrigin(origins = "*")

public class Unidade_medidaService {
	
	@Autowired
	private Unidade_medidaRepository unidade_medidaRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Unidade_medida unidade_medida){ 
 
		try { 
			this.unidade_medidaRepository.save(unidade_medida); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ unidade_medida.getInquilino_id());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Unidade_medida unidade_medida){
 
		try {
 
			this.unidade_medidaRepository.save(unidade_medida);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Unidade_medida> unidade_medida = unidade_medidaRepository.findById(id);
		if (!unidade_medida.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				unidade_medidaRepository.delete(unidade_medida.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Unidade_medida> findById (@PathVariable Long id){
		Optional<Unidade_medida> unidade_medida = unidade_medidaRepository.findById(id);
		
		if (unidade_medida == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(unidade_medida.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Unidade_medida> findAll(@PathVariable Long inquilino){
		return this.unidade_medidaRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}

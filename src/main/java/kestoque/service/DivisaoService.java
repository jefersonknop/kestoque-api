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
import kestoque.entities.Divisao;
import kestoque.repository.DivisaoRepository;


//Jeferson Knop


@RestController
@RequestMapping("/divisoes")
@CrossOrigin(origins = "*")

public class DivisaoService {
	
	@Autowired
	private DivisaoRepository divisaoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Divisao divisao){ 
 
		try { 
			this.divisaoRepository.save(divisao); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ divisao.getId());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Divisao divisao){
 
		try {
 
			this.divisaoRepository.save(divisao);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Divisao> divisao = divisaoRepository.findById(id);
		if (!divisao.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				divisaoRepository.delete(divisao.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Divisao> findById (@PathVariable Long id){
		Optional<Divisao> divisao = divisaoRepository.findById(id);
		
		if (divisao == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(divisao.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Divisao> findAll(@PathVariable Long inquilino){
		return this.divisaoRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}

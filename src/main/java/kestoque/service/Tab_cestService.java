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
import kestoque.entities.Tab_cest;
import kestoque.repository.Tab_cestRepository;


//Jeferson Knop


@RestController
@RequestMapping("/tabs_cest")
@CrossOrigin(origins = "*")

public class Tab_cestService {
	
	@Autowired
	private Tab_cestRepository tab_cestRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Tab_cest tab_cest){ 
 
		try { 
			this.tab_cestRepository.save(tab_cest); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ tab_cest.getId());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Tab_cest tab_cest){
 
		try {
 
			this.tab_cestRepository.save(tab_cest);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Tab_cest> tab_cest = tab_cestRepository.findById(id);
		if (!tab_cest.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				tab_cestRepository.delete(tab_cest.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Tab_cest> findById (@PathVariable Long id){
		Optional<Tab_cest> tab_cest = tab_cestRepository.findById(id);
		
		if (tab_cest == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(tab_cest.get());
					
	}


	@GetMapping
	public @ResponseBody List<Tab_cest> findAll(@PathVariable Long inquilino){
		
		return this.tab_cestRepository.findAll();
	}
	
	
	
 

}

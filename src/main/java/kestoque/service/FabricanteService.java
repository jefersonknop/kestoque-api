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
import kestoque.entities.Fabricante;
import kestoque.repository.FabricanteRepository;


//Jeferson Knop


@RestController
@RequestMapping("/fabricantes")
@CrossOrigin(origins = "*")

public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Fabricante fabricante){ 
 
		try { 
			this.fabricanteRepository.save(fabricante); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ fabricante.getInquilino_id());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Fabricante fabricante){
 
		try {
 
			this.fabricanteRepository.save(fabricante);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Fabricante> fabricante = fabricanteRepository.findById(id);
		if (!fabricante.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				fabricanteRepository.delete(fabricante.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Fabricante> findById (@PathVariable Long id){
		Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
		
		if (fabricante == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(fabricante.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Fabricante> findAll(@PathVariable Long inquilino){
		return this.fabricanteRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}

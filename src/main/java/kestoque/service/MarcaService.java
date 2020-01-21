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
import kestoque.entities.Marca;
import kestoque.repository.MarcaRepository;


//Jeferson Knop


@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*")

public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Marca marca){ 
 
		try { 
			this.marcaRepository.save(marca); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ marca.getInquilino_id());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Marca marca){
 
		try {
 
			this.marcaRepository.save(marca);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Marca> marca = marcaRepository.findById(id);
		if (!marca.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				marcaRepository.delete(marca.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> findById (@PathVariable Long id){
		Optional<Marca> marca = marcaRepository.findById(id);
		
		if (marca == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(marca.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Marca> findAll(@PathVariable Long inquilino){
		return this.marcaRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}

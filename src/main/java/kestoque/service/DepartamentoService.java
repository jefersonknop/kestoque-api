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
import kestoque.entities.Departamento;
import kestoque.repository.DepartamentoRepository;


//Jeferson Knop


@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*")

public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	

	@PostMapping
	public @ResponseBody ResponseModel save(@RequestBody Departamento departamento){ 
 
		try { 
			this.departamentoRepository.save(departamento); 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage()+ " - - - - "+ departamento.getId());			
		}
	}
	

	@PutMapping
	public @ResponseBody ResponseModel update(@RequestBody Departamento departamento){
 
		try {
 
			this.departamentoRepository.save(departamento);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
			
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{id}")	
	public @ResponseBody ResponseModel delete(@PathVariable("id") Long id){ 
		Optional <Departamento> departamento = departamentoRepository.findById(id);
		if (!departamento.isPresent()) {				
			return new ResponseModel(0, "Registro inexistente!");						
		
		}
		else { 		
			try {	 
				departamentoRepository.delete(departamento.get());	 
				return new ResponseModel(1, "Registro excluido com sucesso!");
	 
			}catch(Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}
	
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> findById (@PathVariable Long id){
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		
		if (departamento == null) 
			return ResponseEntity.notFound().build();	 
		else
			return ResponseEntity.ok(departamento.get());
					
	}


	@GetMapping("/inquilino/{inquilino}")
	public @ResponseBody List<Departamento> findAll(@PathVariable Long inquilino){
		return this.departamentoRepository.findByInquilino(inquilino);
		//return this.linhaRepository.findAll();
	}
	
	
	
 

}

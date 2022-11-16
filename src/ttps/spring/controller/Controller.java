package ttps.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Donacion;
import ttps.spring.model.Emprendimiento;
import ttps.spring.model.Usuario;
import ttps.spring.repositories.DonacionRepository;
import ttps.spring.repositories.EmprendimientoRepository;
import ttps.spring.repositories.UsuarioRepository;

@RestController
@RequestMapping("/manguito")
public class Controller {
	
	@Autowired
	private EmprendimientoRepository emprendimientoRepository;
	@Autowired
	private DonacionRepository donacionRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/createEmprendimiento")
	 public ResponseEntity<Emprendimiento> create(@RequestBody Emprendimiento emprendimiento) {
		 System.out.println("Entra al controller");
		 emprendimientoRepository.save(emprendimiento);
		 return new ResponseEntity<Emprendimiento>(emprendimiento, HttpStatus.CREATED);
	}
	
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		 System.out.println("Entra al controller");
		 usuarioRepository.save(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
	@GetMapping("/emprendimiento/{id}")
	 public ResponseEntity<Optional<Emprendimiento>> getEmprendimiento(@PathVariable("id") long id) {
		 System.out.println("Entra al controller");
		 Optional<Emprendimiento> emprendimiento = emprendimientoRepository.findById(id);
		 if (emprendimiento==null) {
			 return new ResponseEntity<Optional<Emprendimiento>>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Optional<Emprendimiento>>(emprendimiento, HttpStatus.OK);
	 }
	
	@PutMapping(value = "/emprendimiento/{id}")
	 public  ResponseEntity<Optional<Emprendimiento>> updateEmprendimiento(@PathVariable("id") long id, @RequestBody Emprendimiento emprendimiento) {
		 Optional<Emprendimiento> currentEmprendimiento = emprendimientoRepository.findById(id);
		 if(currentEmprendimiento.isEmpty()){
			 return new ResponseEntity<Optional<Emprendimiento>>(HttpStatus.NOT_FOUND);
		 }
		 currentEmprendimiento.get().setNombre(emprendimiento.getNombre());
		 currentEmprendimiento.get().setDominio(emprendimiento.getDominio());
		 currentEmprendimiento.get().setPassword(emprendimiento.getPassword());
		 currentEmprendimiento.get().setDescripcion(emprendimiento.getDescripcion());
		 emprendimientoRepository.save(currentEmprendimiento.get());
		 
		 return new ResponseEntity<Optional<Emprendimiento>>(currentEmprendimiento,HttpStatus.OK);
	  }
	
	@GetMapping("/login")
	 public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password){
		 System.out.println("Entra al controller");
		 Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
		 if (usuario==null) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	 }
	
	@PostMapping("/createDonacion")
	 public  ResponseEntity<Donacion> create(@RequestBody Donacion donacion) {
		 System.out.println("entro create");
		 Donacion don = donacionRepository.save(donacion);
		 return new ResponseEntity<Donacion>(don, HttpStatus.CREATED);
	 }
	
	@GetMapping("/getDonacionesEmprendimiento")
	 public ResponseEntity<List<Donacion>> listar(@RequestParam Long idEmprendimiento) {
		 List<Donacion> lista = donacionRepository.findByEmprendimiento(idEmprendimiento);
		 if(lista.isEmpty()){
			 return new ResponseEntity<List<Donacion>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Donacion>>(lista, HttpStatus.OK);
	  }
	
	
	@GetMapping("/probando")
	 public ResponseEntity<Emprendimiento> listar() {
		 System.out.println("Entra al controller");
		 Emprendimiento emprendimiento = new Emprendimiento("Probando","1234");
		 return ResponseEntity.ok(emprendimiento);
	 }
}

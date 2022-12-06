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
import ttps.spring.model.Coleccion;
import ttps.spring.model.Material;
import ttps.spring.model.Modelo;
import ttps.spring.model.Plan;
import ttps.spring.model.Tipo;
import ttps.spring.model.Usuario;
import ttps.spring.repositories.ColeccionRepository;
import ttps.spring.repositories.MaterialRepository;
import ttps.spring.repositories.ModeloRepository;
import ttps.spring.repositories.TipoRepository;
import ttps.spring.repositories.UsuarioRepository;

@RestController
@RequestMapping("/dssd")

public class Controller {
	@Autowired
	private ColeccionRepository coleccionRepository;
	

	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//  CONTROLERS COLECCION
	
	@PostMapping("/createColeccion")
	 public ResponseEntity<Coleccion> createColeccion(@RequestBody Coleccion coleccion) {
		 System.out.println("Entra al controller Coleccion");
		 coleccionRepository.save(coleccion);
		 return new ResponseEntity<Coleccion>(coleccion, HttpStatus.CREATED);
	}
	
	//  CONTROLERS material
	
	@PostMapping("/createDonacion")
	 public ResponseEntity<Material> createDonacion(@RequestBody Material material) {
		 System.out.println("Entra al controller c material");
		 materialRepository.save(material);
		 return new ResponseEntity<Material>(material, HttpStatus.CREATED);
	}
	
	
	
	
	//  CONTROLERS modelo
	
	//anda
	@PostMapping("/createModelo")
	 public ResponseEntity<Modelo> createEmprendimiento(@RequestBody Modelo modelo) {
		 System.out.println("Entra al controller create modelo");
		 modeloRepository.save(modelo);
		 return new ResponseEntity<Modelo>(modelo, HttpStatus.CREATED);
	}
	
	
	

	
	//  CONTROLERS tipo
	
	@PostMapping("/createTipo")
	 public ResponseEntity<Tipo> createPlan(@RequestBody Tipo tipo) {
		 System.out.println("Entra al controller tipo");
		 tipoRepository.save(tipo);
		 return new ResponseEntity<Tipo>(tipo, HttpStatus.CREATED);
	}
	
	

	
	// CONTROLERS Usuario
	
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		 System.out.println("Entra al controller");
		 usuarioRepository.save(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
	
	@GetMapping("/getUsuario")
	 public ResponseEntity<Usuario> getUsuario(@RequestParam("id") long id) {
		 Optional<Usuario> user = usuarioRepository.findById(id);
		 if (user.isEmpty()) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(user.get(), HttpStatus.OK);
	 }

	
	@GetMapping("/login")
	 public ResponseEntity<Usuario> getUser(@RequestParam String username){
		 System.out.println("Entra al controller");
		 Usuario usuario = usuarioRepository.findByNombre(username);
		 if (usuario==null) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	 }
	

	
	//anda
	@GetMapping("/probando")
	 public ResponseEntity<Usuario> listar() {
		 System.out.println("Entra al controller");
		 Usuario user = new Usuario("user1");
		 return ResponseEntity.ok(user);
	 }
}

package cl.zco.rbernedo.jpademo;

import cl.zco.rbernedo.jpademo.model.Category;
import cl.zco.rbernedo.jpademo.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriesRepository categoriesRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola desde mi aplicación!");
		//save();
		//findByid(1);
		//update();
		//deleteById(1);
		deleteAll();
		count();
	}

	private void save(){
		System.out.println("guardando registro!");
		Category cat = new Category();
		cat.setName("Finanzas");
		cat.setDescription("Trabajos realizacionados con finanzas y contabilidad");
		categoriesRepo.save(cat);
		System.out.println(cat);
	}

	private Category findByid(Integer id){
		Optional<Category> optional = categoriesRepo.findById(id);
		if(optional.isPresent()){
			System.out.println(optional.get());
			return optional.get();
		}else{
			System.out.println("No se encontro la categoría");
			return null;
		}
	}

	private void update(){
		Category cat = findByid(1);
		if(cat != null){
			cat.setDescription("Empleos de contabilidad y finanzas");
			categoriesRepo.save(cat);
		}else{
			System.out.println("No se encontro categoría para ser actualizada");
		}
	}

	private void deleteById(Integer id){
		categoriesRepo.deleteById(id);
	}

	private void count(){
		long count = categoriesRepo.count();
		System.out.println("total categorias: "+count);
	}

	private void deleteAll(){
		categoriesRepo.deleteAll();
	}

	private void findAllById(){
		List<Integer> ids = new LinkedList<Integer>();
		categoriesRepo.findAllById(ids);
	}

}

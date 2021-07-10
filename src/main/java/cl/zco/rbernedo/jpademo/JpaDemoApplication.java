package cl.zco.rbernedo.jpademo;

import cl.zco.rbernedo.jpademo.model.Category;
import cl.zco.rbernedo.jpademo.model.Job;
import cl.zco.rbernedo.jpademo.repository.CategoriesRepository;
import cl.zco.rbernedo.jpademo.repository.JobsRepository;
import cl.zco.rbernedo.jpademo.repository.ProfilesRepository;
import cl.zco.rbernedo.jpademo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriesRepository categoriesRepo;

	@Autowired
	private JobsRepository jobsRepo;

	@Autowired
	private UsersRepository usersRepo;

	@Autowired
	private ProfilesRepository profilesRepo;

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
		//deleteAll();
		//findAllById();
		//findAll();
		//saveAll();
		//existById();
		//deleteAllInBatch();
		//count();
		//findAllInOrder();
		//findAllWithPagination();
		//findAllWithPaginationAndOrdered();
		//searchJobs();
		saveJob();
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
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Category> cats = categoriesRepo.findAllById(ids);
		for (Category cat : cats){
			System.out.println(cat);
		}
	}

	private void findAll(){
		List<Category> cats =  categoriesRepo.findAll();
		for(Category cat : cats){
			System.out.println(cat.getId()+" "+cat.getName());
		}
	}

	private void existById(){
		boolean exist = categoriesRepo.existsById(5);
		System.out.println("La categoria existe: "+exist);
	}

	private void saveAll(){
		List<Category> list = new LinkedList<Category>();
		Category cat1 = new Category();
		cat1.setName("Soldador/Pintura");
		cat1.setDescription("Trabajos relacionados con soldadura, pintura y enderazado");
		Category cat2 = new Category();
		cat2.setName("Programador de Blockchain");
		cat2.setDescription("Trabajos relacionados con Bitcoin y Criptomonedas");
		list.add(cat1);
		list.add(cat2);
		categoriesRepo.saveAll(list);
	}

	private void deleteAllInBatch(){
		categoriesRepo.deleteAllInBatch();
	}

	private void findAllInOrder(){
		List<Category> cats =  categoriesRepo.findAll(Sort.by("name").descending());
		for(Category cat : cats){
			System.out.println(cat.getId()+" "+cat.getName());
		}
	}

	private void findAllWithPagination(){
		Page<Category> page = categoriesRepo.findAll(PageRequest.of(0,5));
		System.out.println("Total Registros: "+page.getTotalElements());
		System.out.println("Total Páginas: "+page.getTotalPages());
		for(Category cat : page.getContent()){
			System.out.println(cat.getId()+" "+cat.getName());
		}
	}

	private void findAllWithPaginationAndOrdered(){
		Page<Category> page = categoriesRepo.findAll(PageRequest.of(0,5, Sort.by("name").descending()));
		System.out.println("Total Registros: "+page.getTotalElements());
		System.out.println("Total Páginas: "+page.getTotalPages());
		for(Category cat : page.getContent()){
			System.out.println(cat.getId()+" "+cat.getName());
		}
	}

	private void searchJobs(){
		List<Job> list = jobsRepo.findAll();
		for(Job job : list){
			System.out.println(job.getId() +" "+job.getName()+" -> "+job.getCategory().getName());
		}
	}

	private void saveJob(){
		Job job = new Job();
		job.setName("Profesor de Matemáticas");
		job.setDescription("Escuela primaria solicita profesor para curso de Matemáticas");
		job.setPublicationDate(new Date());
		job.setSalary(8500.0);
		job.setStatus("Aprobada");
		job.setFeatured(0);
		job.setImage("escuela.png");
		job.setDescription("<h1>Los requisitos para profesor de matemáticas</h1>");
		Category cat = new Category();
		cat.setId(15);
		job.setCategory(cat);
		jobsRepo.save(job);
	}

}

package com.perso.ppm;

import com.perso.ppm.domain.Project;
import com.perso.ppm.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PpmApplication implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(PpmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019");

		Project project = projectRepository.save(new Project("PPM", "Personal Project Management Tool",
				"Project developed with spring boot & react js", new Date(), deadline));

		List<Project> projects = projectRepository.findAll();
		for(Project p : projects) {
			System.out.println(p.toString());
		}
	}
}

package com.santander.crm.sinergia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.santander.crm.sinergia.dao.ImagenRepository;
import com.santander.crm.sinergia.entity.Imagen;

@SpringBootApplication
public class CatalogosApplication  implements CommandLineRunner {
	
	@Autowired
	ImagenRepository imagenRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogosApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
//		// image 1
//		ClassPathResource banner = new ClassPathResource("image/jsa_about_img_black_background.png");
//		byte[] arrayPic = new byte[(int) banner.contentLength()];
//		banner.getInputStream().read(arrayPic);
//		Imagen blackImage = new Imagen(0, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", arrayPic);
		
//		// image 2
//		ClassPathResource blueImgFile = new ClassPathResource("image/jsa_about_img_blue_background.png");
//		arrayPic = new byte[(int) blueImgFile.contentLength()];
//		blueImgFile.getInputStream().read(arrayPic);
//		Imagen blueImage = new Imagen(0, "JSA-ABOUT-IMAGE-BLUE-BACKGROUND", arrayPic);
		
		// store image to MySQL via SpringJPA
//		imagenRepository.save(blackImage);
//		imagenRepository.save(blueImage);
		
		// retrieve image from MySQL via SpringJPA
		for(Imagen imageModel : imagenRepository.findAll()){
			Files.write(Paths.get("src/main/resources/img/" + imageModel.getNombre() + ".png"), imageModel.getImagen());
		}
	}
}

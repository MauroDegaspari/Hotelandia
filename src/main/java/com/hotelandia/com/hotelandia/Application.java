package com.hotelandia.com.hotelandia;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.hotelandia.com.hotelandia.model.DadosHotel;
import com.hotelandia.com.hotelandia.repository.HotelRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner init(HotelRepository repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
			.mapToObj( i -> {
				DadosHotel h = new DadosHotel();
				h.setNome("Hotelandia User" + i);
				h.setCapacidade(23);
				h.setCep(i+i+i+i+"-"+i+i+i);
				h.setRua(" R" + i);
				h.setN(2);
				h.setBairro("Campo");
				h.setEstado("PE");
				h.setCidade("recife");
				
				return h;
			})
			.map(m -> repository.save(m))
			.forEach(System.out::println);
		};
	}
}

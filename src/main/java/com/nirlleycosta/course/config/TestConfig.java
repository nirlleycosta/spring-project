package com.nirlleycosta.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nirlleycosta.course.entities.Category;
import com.nirlleycosta.course.entities.Order;
import com.nirlleycosta.course.entities.Product;
import com.nirlleycosta.course.entities.User;
import com.nirlleycosta.course.entities.enums.OrderStatus;
import com.nirlleycosta.course.repositories.CategoryRepository;
import com.nirlleycosta.course.repositories.OrderRepository;
import com.nirlleycosta.course.repositories.ProductRepository;
import com.nirlleycosta.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(null, "The Lord of the Rings", "Be an authentic geek with this essential book", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Samsung", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "You know how we do it", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Play it for hours and never get bored", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dumies", "Just read it noob", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Daniel Doo", "daniel@gmail.com", "999999999", "456789");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}

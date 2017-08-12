package com.example.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.AccessBookResponse;
import com.example.models.BookResponse;
import com.example.models.CustomerResponse;
import com.example.models.FeedbackBookResponse;
import com.example.models.PublisherResponse;
import com.example.models.SaleBookResponse;

@Service
public class BookService {

	public List<FeedbackBookResponse> getFeedbackByPublisher(int publisherId) {
		CustomerResponse customer = new CustomerResponse();
		customer.setFirstName("Spike");
		customer.setLastName("Doe");
		customer.setEmail("spike.doe@example.com");

		CustomerResponse customer1 = new CustomerResponse();
		customer1.setFirstName("Gal");
		customer1.setLastName("Doe");
		customer1.setEmail("dal.doe@example.com");

		PublisherResponse publisher = buildPublisher(publisherId);
		BookResponse book = buildBook(1, publisher);
		BookResponse book1 = buildBook(2, publisher);

		return Arrays.asList(buildFeedback(customer, book), buildFeedback(customer1, book),
				buildFeedback(customer, book1), buildFeedback(customer1, book1));
	}

	public List<FeedbackBookResponse> getFeedbackByBook(int bookId) {
		CustomerResponse customer = new CustomerResponse();
		customer.setFirstName("Spike");
		customer.setLastName("Doe");
		customer.setEmail("spike.doe@example.com");

		CustomerResponse customer1 = new CustomerResponse();
		customer1.setFirstName("Gal");
		customer1.setLastName("Doe");
		customer1.setEmail("dal.doe@example.com");

		PublisherResponse publisher = buildPublisher(1);
		BookResponse book = buildBook(bookId, publisher);

		return Arrays.asList(buildFeedback(customer, book), buildFeedback(customer1, book));
	}

	private FeedbackBookResponse buildFeedback(CustomerResponse customer, BookResponse book) {
		FeedbackBookResponse feedback = new FeedbackBookResponse();
		feedback.setBook(book);
		feedback.setCustomer(customer);
		feedback.setFeedbackDate(new Date());
		feedback.setFeedback("Feedback Example");
		return feedback;
	}

	public List<SaleBookResponse> getSalesByPublisher(int publisherId) {
		CustomerResponse customer = new CustomerResponse();
		customer.setFirstName("Dylan");
		customer.setLastName("Doe");
		customer.setEmail("dylan.doe@example.com");

		CustomerResponse customer1 = new CustomerResponse();
		customer1.setFirstName("Lisa");
		customer1.setLastName("Doe");
		customer1.setEmail("lisa.doe@example.com");

		PublisherResponse publisher = buildPublisher(publisherId);
		BookResponse book = buildBook(1, publisher);
		BookResponse book1 = buildBook(2, publisher);

		return Arrays.asList(buildSaleBook(customer, book), buildSaleBook(customer, book),
				buildSaleBook(customer, book1), buildSaleBook(customer1, book1));
	}

	public List<SaleBookResponse> getSalesByBook(int bookId) {
		CustomerResponse customer = new CustomerResponse();
		customer.setFirstName("Johnson");
		customer.setLastName("Doe");
		customer.setEmail("johnson.doe@example.com");

		CustomerResponse customer1 = new CustomerResponse();
		customer1.setFirstName("Hilary");
		customer1.setLastName("Doe");
		customer1.setEmail("hilary.doe@example.com");

		PublisherResponse publisher = buildPublisher(1);
		BookResponse book = buildBook(bookId, publisher);

		return Arrays.asList(buildSaleBook(customer, book), buildSaleBook(customer1, book));
	}

	private SaleBookResponse buildSaleBook(CustomerResponse customer, BookResponse book) {
		SaleBookResponse sale = new SaleBookResponse();
		sale.setBook(book);
		sale.setCustomer(customer);
		sale.setSaleDate(new Date());
		return sale;
	}

	public List<AccessBookResponse> getAccessByPublisher(int publisherId) {
		CustomerResponse customerJimmy = new CustomerResponse();
		customerJimmy.setFirstName("Jimmy");
		customerJimmy.setLastName("Doe");
		customerJimmy.setEmail("jimmy.doe@example.com");

		CustomerResponse customerBruce = new CustomerResponse();
		customerBruce.setFirstName("Bruce");
		customerBruce.setLastName("Doe");
		customerBruce.setEmail("bruce.doe@example.com");

		PublisherResponse publisher = buildPublisher(publisherId);

		BookResponse book = buildBook(1, publisher);
		BookResponse book1 = buildBook(2, publisher);

		return Arrays.asList(buildAccessBook(customerJimmy, book), buildAccessBook(customerBruce, book),
				buildAccessBook(customerJimmy, book1), buildAccessBook(customerBruce, book1));
	}

	public List<AccessBookResponse> getAccessByBook(int bookId) {
		CustomerResponse customerJohn = new CustomerResponse();
		customerJohn.setFirstName("John");
		customerJohn.setLastName("Doe");
		customerJohn.setEmail("john.doe@example.com");

		CustomerResponse customerMary = new CustomerResponse();
		customerMary.setFirstName("Mary");
		customerMary.setLastName("Doe");
		customerMary.setEmail("mary.doe@example.com");

		PublisherResponse publisher = buildPublisher(bookId);
		BookResponse book = buildBook(bookId, publisher);

		return Arrays.asList(buildAccessBook(customerJohn, book), buildAccessBook(customerMary, book));
	}

	private AccessBookResponse buildAccessBook(CustomerResponse customer, BookResponse book) {
		AccessBookResponse accessBookJohn = new AccessBookResponse();
		accessBookJohn.setBook(book);
		accessBookJohn.setCustomer(customer);
		accessBookJohn.setAccessDate(new Date());
		return accessBookJohn;
	}

	private PublisherResponse buildPublisher(int id) {
		PublisherResponse publisherExample = new PublisherResponse();
		publisherExample.setId(id);
		publisherExample.setName("Publisher " + id);
		return publisherExample;
	}

	private BookResponse buildBook(int id, PublisherResponse publisher) {
		BookResponse bookExample = new BookResponse();
		bookExample.setId(id);
		bookExample.setTitle("Book example " + id);
		bookExample.setAuthor("Author one, author two");
		bookExample.setPublicationDate(new Date());
		bookExample.setPublisher(publisher);
		return bookExample;
	}
}

package br.com.lucasalbertoni.course.flutterwebapi.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasalbertoni.course.flutterwebapi.entity.Transaction;

@RestController
@RequestMapping("/transactions")
public class TransactionAPI {
	
	private final Map<String, Transaction> transactions = new HashMap<>();
	
	@GetMapping
	public List<Transaction> get(){
		return new ArrayList<Transaction>(transactions.values());
	}
	
	@PostMapping
	public Transaction set(@RequestBody Transaction transaction) {
		String id = UUID.randomUUID().toString();
		transaction.setId(id);
		transaction.setDateTime(LocalDateTime.now());
		transactions.put(id, transaction);
		return transaction;
	}

}

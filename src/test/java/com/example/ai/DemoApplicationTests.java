package com.example.ai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	private VectorStore vectorStore;

	@Test
	void test() {
		//初始化文章
		List<Document> documents = List.of(
				new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
				new Document("The World is Big and Salvation Lurks Around the Corner"),
				new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));

		//存储
		vectorStore.add(documents);

		//查询top 5
		List<Document> results = vectorStore.similaritySearch(SearchRequest.builder().query("Spring").topK(5).build());
	}

}

package com.example.testcode.ch04;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace =
	AutoConfigureTestDatabase.Replace.ANY, // 테스트에서 사용되는 모든 데이터 소스를 자동으로 교체
	connection = EmbeddedDatabaseConnection.H2 // 내장 데이터베이스를 사용
)
public class SpringBootTestExampleTest {



}

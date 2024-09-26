package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //http관련된 코드 및 요청/응답 매핑을 스프링이 알아서 해준다.
//@RequestMapping("test") //localhost:9090/test로 접속을 시도하면 이 컨트롤러(TestController 클래스)로 요청이 들어온다.
public class TestController {
	
	@GetMapping("/testGetMapping") //get요청으로 들어오면 아래의 메서드를 실행시켜달라는 의미이다.
	public String testController() {
		return "Hello World";
	}
	
	@PostMapping //POST요청이 들어왔을 때 실행
	public String TestController2() {
		return "Hello World2";
	}
	
	@PutMapping // PUT요청이 들어왔을 때 실행
	public String TestController3() {
		return "Hello World3";
	}
	
	@DeleteMapping // DELETE요청이 들어왔을 때 실행
	public String TestController4() {
		return "Hello World4";
	}
	
}

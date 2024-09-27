package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;

//@Controller // View(html, jsp, thymeleaf)를 반환
@RestController // 이 클래스가 컨트롤러임을 명시하는 어노테이션
@RequestMapping("todo")
@RequiredArgsConstructor
//final이나 @NonNull이 붙어있는 필드만 생성자의 매개변수로 생성
public class TodoController {
	
	//TodoService 의존성 주입하기
	//@Autowired
	//private todoService todoService;
	
	//@RequiredArgsConstructor가 final이나 @NonNull이 붙어있어야하기 때문에
	//final을 붙임
	private final TodoService service;
	
	
	//다른 클래스에 있는 메서드를 사용하기 위해 객체를 우선 만들어야 한다.
	//스프링에서는 객체를 이미 만들어놨기 때문에 주입만 하면 된다.
	
	//Get/todo/test로 요청했을 때 testTodo()메서드 호출되도록 정의하기
	//testTodo에서는 TodoService의 메서드를 호출하여 결과를 ResponseDTO의 리스트에 추가한다.
	//ResponseEntity.ok().body(response)로 반환하기
	
	//아래의 메서드가 실행되기 위한 조건
	//브라우저에 주소가 호출되어야 한다. localhost:9090/todo/test
	@GetMapping("/test")
	public ResponseEntity<?> testTodo(){
		String str = service.testService();
		//리스트의 생성
		//인덱스를 가지고 크기에 제한이 없는 자료구조
		List<String> list = new ArrayList<>();
		//리스트에 값 추가하기 list.add(value)
		list.add(str);
		//ResponseDTO 객체 생성
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		//ResponseEntity의 body에 response를 실어서 응답을 보낸다.
		return ResponseEntity.ok().body(response);
	}
	
	
	
}

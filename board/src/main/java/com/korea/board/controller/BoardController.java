package com.korea.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.board.dto.BoardDTO;
import com.korea.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	//1. 조회 "/all"
	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts(){
		List<BoardDTO> dtos = service.getAllPosts();
		
	}
	
	//1-1. 한건 조회 "/get/{id}"
	
	//2. 추가 "/write"
	
	//3. 수정 "/modify/{id}"
	
	//4. 삭제 "/delete/{id}"
}

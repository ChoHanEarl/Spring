package com.korea.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.board.dto.BoardDTO;
import com.korea.board.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository repository;
	
	//1. 조회
	//public List<BoardDTO> getAllPosts(){
		//return repository.findAll().stream().map(this::);
	//}
	//2. 추가 
	
	//3. 수정
	
	//4. 삭제
	
	//Entity -> DTO 변환함수
	
	//DTO -> Entity 변환함수
}

package com.korea.board.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.board.model.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

}

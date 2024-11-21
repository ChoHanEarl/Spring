package com.korea.board.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
	private String error;
	private T data;
}


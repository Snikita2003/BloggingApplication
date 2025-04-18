package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponce;
import com.blog.payloads.CommentDto;
import com.blog.services.CommentServiceImpl;




@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentServiceImpl commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commentDto,
			@PathVariable Integer postId
			){
		CommentDto createdComment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponce> deleteComment(@PathVariable Integer commentId)
	{
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponce>(new ApiResponce("Comment deleted successfully!!", true), HttpStatus.OK);
		
	}
	
	
}
package com.sparta.todoproject_jwt.service;

import com.sparta.todoproject_jwt.dto.CommentRequestDto;
import com.sparta.todoproject_jwt.dto.CommentResponseDto;
import com.sparta.todoproject_jwt.entity.Comment;
import com.sparta.todoproject_jwt.entity.Todo;
import com.sparta.todoproject_jwt.entity.User;
import com.sparta.todoproject_jwt.repository.CommentRepository;
import com.sparta.todoproject_jwt.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;


    public CommentResponseDto createCommentByTodoId(Long id, User user, CommentRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 id의 할일이 없습니다."));
        if(todo.isPrivate()&&!todo.getUser().getUsername().equals(user.getUsername()))
            throw new IllegalArgumentException("댓글을 작성할 권한이 없습니다.");

        Comment comment = commentRepository.save(new Comment(user, todo, requestDto));
        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateCommentById(Long id, User user, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 id의 댓글이 없습니다."));
        if(!comment.getUser().getUsername().equals(user.getUsername()))
            throw new IllegalArgumentException("댓글을 수정할 권한이 없습니다.");

           comment.update(requestDto);
           return new CommentResponseDto(comment);

    }

    public String deleteCommentById(Long id, User user) {
        Comment comment = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 id의 댓글이 없습니다."));
        if(!comment.getUser().getUsername().equals(user.getUsername()))
            throw new IllegalArgumentException("댓글을 삭제할 권한이 없습니다.");


            commentRepository.deleteById(id);
            return "삭제되었습니다.";

    }
}

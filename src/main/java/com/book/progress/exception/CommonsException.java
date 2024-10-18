package com.book.progress.exception;

import com.book.progress.data.dto.MessageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CommonsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -4694258578216919456L;

    protected HttpStatus status;
    protected String key;
    protected String text;

    public ResponseEntity<MessageDto> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDto(text,key));
    }
}

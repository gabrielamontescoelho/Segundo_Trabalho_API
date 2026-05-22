package br.com.serratec.segundotrabalhoapi.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarErroValidacao(MethodArgumentNotValidException ex){
        List<String> erros = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(erro -> erro.getField()+ ":" + erro.getDefaultMessage())
            .toList();
            ErroResposta resposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(),"Erro validação",LocalDateTime.now(),erros);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResposta> tratarNotfound(NotFoundException ex){
        ErroResposta resposta = new ErroResposta(HttpStatus.NOT_FOUND.value(),"Recurso não encontrado",LocalDateTime.now(),List.of(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

}

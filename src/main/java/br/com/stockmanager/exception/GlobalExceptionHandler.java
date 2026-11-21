package br.com.stockmanager.exception;
import jakarta.servlet.http.HttpServletRequest; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.stream.Collectors;
@RestControllerAdvice public class GlobalExceptionHandler{
 record ErrorResponse(LocalDateTime timestamp,int status,String error,String message,String path){}
 @ExceptionHandler(ResourceNotFoundException.class) ResponseEntity<ErrorResponse> notFound(ResourceNotFoundException e,HttpServletRequest r){return response(HttpStatus.NOT_FOUND,e.getMessage(),r);}
 @ExceptionHandler({BusinessException.class,DuplicateResourceException.class}) ResponseEntity<ErrorResponse> business(RuntimeException e,HttpServletRequest r){return response(e instanceof DuplicateResourceException?HttpStatus.CONFLICT:HttpStatus.UNPROCESSABLE_ENTITY,e.getMessage(),r);}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException e,HttpServletRequest r){String m=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).collect(Collectors.joining("; "));return response(HttpStatus.BAD_REQUEST,m,r);}
 @ExceptionHandler(Exception.class) ResponseEntity<ErrorResponse> generic(Exception e,HttpServletRequest r){return response(HttpStatus.INTERNAL_SERVER_ERROR,"Erro interno do servidor.",r);}
 private ResponseEntity<ErrorResponse> response(HttpStatus s,String m,HttpServletRequest r){return ResponseEntity.status(s).body(new ErrorResponse(LocalDateTime.now(),s.value(),s.getReasonPhrase(),m,r.getRequestURI()));}
}

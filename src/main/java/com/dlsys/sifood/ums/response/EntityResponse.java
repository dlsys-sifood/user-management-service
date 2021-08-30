package com.dlsys.sifood.ums.response;

import com.dlsys.sifood.ums.dto.GenericResponse;
import com.dlsys.sifood.ums.dto.UserResponse;
import com.dlsys.sifood.ums.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityResponse {

    private static final String BADREQUESTCODE = HttpStatus.BAD_REQUEST.toString();
    private static final String BADREQUESTDESCRIPTION = "BAD REQUEST";

    private static final String NOTFOUNDCODE = HttpStatus.NOT_FOUND.toString();
    private static final String NOTFOUNDDESCRIPTION = "NOT FOUND";

    private static final String OKREQUESTCODE = HttpStatus.OK.toString();
    private static final String OKREQUESTDESCRIPTION = "OK";

    public static ResponseEntity<?> getErrorsFieldResponse(BindingResult result){
        return new ResponseEntity<Map<String, Object>>(ListResponse
                .responseRequest(new GenericResponse(BADREQUESTCODE, BADREQUESTDESCRIPTION,
                        result.getFieldErrors().stream()
                                .map(e -> "el campo: " + e.getField() + " " + e.getDefaultMessage())
                                .collect(Collectors.toList())))
                , HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> getNotFoundMessage(){
        return new ResponseEntity<Map<String, Object>>(ListResponse
                .responseRequest(new GenericResponse(NOTFOUNDCODE, NOTFOUNDDESCRIPTION,
                        GenericResponse.toList("consulta no encontrada")))
                , HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> getErrorCustomMessage(String custom){
        return new ResponseEntity<Map<String, Object>>(ListResponse
                .responseRequest(new GenericResponse(BADREQUESTCODE, BADREQUESTDESCRIPTION,
                        GenericResponse.toList(custom)))
                , HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> getSuccessfullListUser(List<Users> response){
        return new ResponseEntity<Map<String, Object>>(ListResponse.userSuccesfulResponse(new UserResponse(
                OKREQUESTCODE, OKREQUESTDESCRIPTION, GenericResponse.toList("Consulta Encontrada"), response)),
                HttpStatus.OK);
    }

    public static ResponseEntity<?> getSuccessfullUser(Users response){
        return new ResponseEntity<Map<String, Object>>(ListResponse.userSuccesfulResponse(
                new UserResponse(OKREQUESTCODE, OKREQUESTDESCRIPTION,
                        GenericResponse.toList("el usuario se a creado correctamente"), response)),
                HttpStatus.OK);
    }

    public static ResponseEntity<?> getSuccessfullUserAuthentication(Users response){
        return new ResponseEntity<Users>(response, HttpStatus.OK);
    }
}

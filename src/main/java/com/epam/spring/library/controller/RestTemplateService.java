package com.epam.spring.library.controller;

import com.epam.spring.library.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/template")
@RequiredArgsConstructor
public class RestTemplateService {
    RestTemplate restTemplate;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/users")
    public String getUserList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8080/users", HttpMethod.GET, entity, String.class).getBody();
    }

    @GetMapping(value = "/users/{id}")
    public String getUserById(@PathVariable("id") long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/users/" + id, HttpMethod.GET, entity, String.class).getBody();
    }

    @PostMapping(value = "/users")
    public String createUser(@RequestBody @Valid UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        return restTemplate.exchange(
                "http://localhost:8080/users", HttpMethod.POST, entity, String.class).getBody();
    }

    @PutMapping(value = "/users")
    public String updateUser(@Valid @RequestBody UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        return restTemplate.exchange(
                "http://localhost:8080/users", HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/users/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

}

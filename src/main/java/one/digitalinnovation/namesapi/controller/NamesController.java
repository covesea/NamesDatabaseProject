package one.digitalinnovation.namesapi.controller;

import one.digitalinnovation.namesapi.dto.MessageResponseDTO;
import one.digitalinnovation.namesapi.entity.Names;
import one.digitalinnovation.namesapi.repository.NamesRepository;
import one.digitalinnovation.namesapi.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0")
public class NamesController {

    private NamesService namesService;

    public NamesController(NamesService namesService) {
        this.namesService = namesService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MessageResponseDTO createName(@RequestBody Names names) {
        return namesService.createName(names);
    }

}

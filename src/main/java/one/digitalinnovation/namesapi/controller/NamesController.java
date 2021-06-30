package one.digitalinnovation.namesapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.namesapi.dto.MessageResponseDTO;
import one.digitalinnovation.namesapi.dto.request.NamesDTO;
import one.digitalinnovation.namesapi.exception.NameNotFoundException;
import one.digitalinnovation.namesapi.service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v0")

public class NamesController {

    private NamesService namesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createName(@RequestBody @Valid NamesDTO namesDTO) {
        return namesService.createName(namesDTO);
    }

    @GetMapping
    public List<NamesDTO> listAll() {
        return namesService.listAll();
    }

    @GetMapping("/{id}")
    public NamesDTO findById(@PathVariable Long id) throws NameNotFoundException {
        return namesService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateName(@PathVariable Long id, @RequestBody @Valid NamesDTO namesDTO) throws NameNotFoundException {
        return namesService.updateName(id, namesDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NameNotFoundException{
        namesService.delete(id);
    }
}

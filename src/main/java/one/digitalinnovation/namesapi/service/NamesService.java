package one.digitalinnovation.namesapi.service;

import one.digitalinnovation.namesapi.dto.MessageResponseDTO;
import one.digitalinnovation.namesapi.entity.Names;
import one.digitalinnovation.namesapi.repository.NamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class NamesService {
    private NamesRepository namesRepository;

    @Autowired
    public NamesService(NamesRepository namesRepository) {
        this.namesRepository = namesRepository;
    }
    public MessageResponseDTO createName(Names names) {
        Names namesSaved = namesRepository.save(names);
        return MessageResponseDTO
                .builder()
                .message("Name saved on ID: " + namesSaved.getId())
                .build();
    }
}

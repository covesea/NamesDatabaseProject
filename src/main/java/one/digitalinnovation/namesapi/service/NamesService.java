package one.digitalinnovation.namesapi.service;

import one.digitalinnovation.namesapi.dto.MessageResponseDTO;
import one.digitalinnovation.namesapi.dto.request.NamesDTO;
import one.digitalinnovation.namesapi.entity.Names;
import one.digitalinnovation.namesapi.exception.NameNotFoundException;
import one.digitalinnovation.namesapi.mapper.NamesMapper;
import one.digitalinnovation.namesapi.repository.NamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NamesService {

    private NamesRepository namesRepository;

    private final NamesMapper namesMapper = NamesMapper.INSTANCE;

    @Autowired
    public NamesService(NamesRepository namesRepository) {
        this.namesRepository = namesRepository;
    }

    public MessageResponseDTO createName(NamesDTO namesDTO) {
        Names namesToSave = namesMapper.toModel(namesDTO);

        Names namesSaved = namesRepository.save(namesToSave);
        return MessageResponseDTO
                .builder()
                .message("Name saved on ID: " + namesSaved.getId())
                .build();
    }

    public List<NamesDTO> listAll() {
        List<Names> allNames = namesRepository.findAll();
        return allNames.stream()
                .map(namesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NamesDTO findById(Long id) throws NameNotFoundException{
       Names name = namesRepository.findById(id)
            .orElseThrow(() -> new NameNotFoundException(id));
       return namesMapper.toDTO(name);
    }
}

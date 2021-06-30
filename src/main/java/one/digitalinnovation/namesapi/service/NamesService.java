package one.digitalinnovation.namesapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.namesapi.dto.MessageResponseDTO;
import one.digitalinnovation.namesapi.dto.request.NamesDTO;
import one.digitalinnovation.namesapi.entity.Names;
import one.digitalinnovation.namesapi.exception.NameNotFoundException;
import one.digitalinnovation.namesapi.mapper.NamesMapper;
import one.digitalinnovation.namesapi.repository.NamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class NamesService {

    private NamesRepository namesRepository;

    private final NamesMapper namesMapper = NamesMapper.INSTANCE;

    public MessageResponseDTO createName(NamesDTO namesDTO) {
        Names namesToSave = namesMapper.toModel(namesDTO);

        Names namesSaved = namesRepository.save(namesToSave);
        return createMessageResponse(namesSaved.getId(), "This ID was just saved ' ' ");
    }

    public List<NamesDTO> listAll() {
        List<Names> allNames = namesRepository.findAll();
        return allNames.stream()
                .map(namesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NamesDTO findById(Long id) throws NameNotFoundException {
       Names name = verifyIfExist(id);
       return namesMapper.toDTO(name);
    }

    public void delete(Long id) throws NameNotFoundException {
       verifyIfExist(id);

        namesRepository.deleteById(id);
    }

    public MessageResponseDTO updateName(Long id, NamesDTO namesDTO) throws NameNotFoundException {
        verifyIfExist(id);

        Names updateNameId = namesMapper.toModel(namesDTO);

        Names namesUpdated = namesRepository.save(updateNameId);
        return createMessageResponse(namesUpdated.getId(), "Name was just updated with ID ");
    }

    private Names verifyIfExist(Long id) throws NameNotFoundException {
        return namesRepository.findById(id)
                .orElseThrow(() -> new NameNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }

}

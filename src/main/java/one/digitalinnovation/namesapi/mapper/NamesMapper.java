package one.digitalinnovation.namesapi.mapper;

import one.digitalinnovation.namesapi.dto.request.NamesDTO;
import one.digitalinnovation.namesapi.entity.Names;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NamesMapper {
    NamesMapper INSTANCE = Mappers.getMapper(NamesMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Names toModel(NamesDTO namesDTO);
    NamesDTO toDTO(Names names);
}

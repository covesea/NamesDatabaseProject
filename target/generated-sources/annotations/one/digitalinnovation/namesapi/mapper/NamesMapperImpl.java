package one.digitalinnovation.namesapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.namesapi.dto.request.NamesDTO;
import one.digitalinnovation.namesapi.entity.Address;
import one.digitalinnovation.namesapi.entity.Names;
import one.digitalinnovation.namesapi.entity.Phone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-29T19:39:51-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class NamesMapperImpl implements NamesMapper {

    @Override
    public Names toModel(NamesDTO namesDTO) {
        if ( namesDTO == null ) {
            return null;
        }

        Names names = new Names();

        if ( namesDTO.getBirthDate() != null ) {
            names.setBirthDate( LocalDate.parse( namesDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        names.setId( namesDTO.getId() );
        names.setFirstName( namesDTO.getFirstName() );
        names.setLastName( namesDTO.getLastName() );
        names.setCpf( namesDTO.getCpf() );
        List<Phone> list = namesDTO.getPhones();
        if ( list != null ) {
            names.setPhones( new ArrayList<Phone>( list ) );
        }
        List<Address> list1 = namesDTO.getAddresses();
        if ( list1 != null ) {
            names.setAddresses( new ArrayList<Address>( list1 ) );
        }

        return names;
    }

    @Override
    public NamesDTO toDTO(Names names) {
        if ( names == null ) {
            return null;
        }

        NamesDTO namesDTO = new NamesDTO();

        namesDTO.setId( names.getId() );
        namesDTO.setFirstName( names.getFirstName() );
        namesDTO.setLastName( names.getLastName() );
        namesDTO.setCpf( names.getCpf() );
        if ( names.getBirthDate() != null ) {
            namesDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( names.getBirthDate() ) );
        }
        List<Phone> list = names.getPhones();
        if ( list != null ) {
            namesDTO.setPhones( new ArrayList<Phone>( list ) );
        }
        List<Address> list1 = names.getAddresses();
        if ( list1 != null ) {
            namesDTO.setAddresses( new ArrayList<Address>( list1 ) );
        }

        return namesDTO;
    }
}

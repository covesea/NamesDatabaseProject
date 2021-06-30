package one.digitalinnovation.namesapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.namesapi.entity.Address;
import one.digitalinnovation.namesapi.entity.Phone;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NamesDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;

    @Valid
    @NotEmpty
    private List<Address> addresses;
}

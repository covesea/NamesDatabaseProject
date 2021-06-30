package one.digitalinnovation.namesapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressesDTO {

    private Long id;

    @NotEmpty
    @Size(min = 4, max = 100)
    private String addressName;

    @NotEmpty
    @Size(min = 1, max = 6)
    private Long addressNumber;

    @NotEmpty
    @Size(min = 8, max = 8)
    private String postalCode;

}
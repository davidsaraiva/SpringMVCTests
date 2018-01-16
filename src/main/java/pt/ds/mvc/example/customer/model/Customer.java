package pt.ds.mvc.example.customer.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import pt.ds.mvc.example.validation.CourseCode;

@Data
@NoArgsConstructor
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 3, message = "Size must be grater than 3")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{3}", message = "only xxxx-xxx")
    private String postalCode;

    @CourseCode(value = {"DS", "LUV"}, message = "must start with DS or LUV")
    private String courseCode;

}

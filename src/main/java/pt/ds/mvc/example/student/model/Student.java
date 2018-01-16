package pt.ds.mvc.example.student.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private String country;

    private String favoriteLanguage;

    private List<String> operatingSystems;

}

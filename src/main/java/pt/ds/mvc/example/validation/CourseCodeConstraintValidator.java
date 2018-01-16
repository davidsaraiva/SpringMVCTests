package pt.ds.mvc.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code == null) {
            return false;
        }

        for (String prefix : coursePrefix) {
            boolean foundPrefix = code.startsWith(prefix);
            if (foundPrefix) {
                return true;
            }
        }
        return false;
    }
}

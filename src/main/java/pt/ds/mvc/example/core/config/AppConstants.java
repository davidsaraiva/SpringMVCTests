package pt.ds.mvc.example.core.config;

public class AppConstants {

    private static final String CORE_VIEWS = "core/view/";

    private static final String CUSTOMER_VIEWS = "customer/view/";

    private static final String STUDENT_VIEWS = "student/view/";

    public static String studentView(String view) {
        return STUDENT_VIEWS + view;
    }

    public static String customerView(String view) {
        return CUSTOMER_VIEWS + view;
    }

    public static String coreView(String view) {
        return CORE_VIEWS + view;
    }
}

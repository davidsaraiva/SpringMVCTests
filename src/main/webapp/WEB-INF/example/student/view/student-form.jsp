<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Registration Form</title>
    </head>

    <body>
        <form:form action="processForm" method="POST" modelAttribute="student">

            First Name: <form:input type="text" path="firstName" />
            <br />
            Last Name: <form:input type="text" path="lastName" />
            <br />

            Country :

            <form:select path="country">
                <form:options items="${theCountryOptions}" />
            </form:select>

            <%--
            <form:select path="country">
                <form:options items="${student.countryOptions}" />
            </form:select>

            <form:select path="country">
                <form:option value="Brazil" label="Brazil" />
                <form:option value="France" label="France" />
                <form:option value="Germany" label="Germany" />
                <form:option value="India" label="India" />
            </form:select>
            --%>

            <br />
            Favorite Language:
            Java <form:radiobutton path="favoriteLanguage" value="Java" />
            C# <form:radiobutton path="favoriteLanguage" value="C#" />
            PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
            Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

            <br />
            Operating Systems:
            Linux <form:checkbox path="operatingSystems" value="Linux" />
            Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
            MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />

            <br />
            <input type="submit" value="Submit"/>

        </form:form>

    </body>
</html>
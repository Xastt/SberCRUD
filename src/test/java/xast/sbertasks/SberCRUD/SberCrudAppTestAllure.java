package xast.sbertasks.SberCRUD;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import xast.sbertasks.SberCRUD.controllers.PersonController;
import xast.sbertasks.SberCRUD.models.Person;
import xast.sbertasks.SberCRUD.services.PersonService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Epic("Person Management")
@Feature("Person Controller")
public class SberCrudAppTestAllure {

    @MockitoBean
    PersonService personService;

    @Autowired
    private PersonController personController;

    @Test
    @Story("Get All Users")
    @Description("Test to verify the retrival of all users")
    public void getAllUsers() {
        List<Person> personList = Arrays.asList(
                new Person("Ivanov", "Ivan", 22),
                new Person("Pavlov", "Pavel",33)
        );
        when(personService.findAll()).thenReturn(personList);

        //для передачи экземпляров класса
        Model model = new ExtendedModelMap();
        String viewName = personController.index(model);

        assertEquals("index", viewName);
        assertEquals(personList, model.getAttribute("person"));

    }

}

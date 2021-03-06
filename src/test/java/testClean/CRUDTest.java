package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.ProjectCRUD;

public class CRUDTest extends BaseTodoLy   {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    ProjectCRUD projectCRUD = new ProjectCRUD();

    @Test
    public void verifyLoginTodoLy() throws InterruptedException {

        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("rodriviladegut@gmail.com");
        loginModal.pwdTxtBox.setText("12345");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR no se pudo hacer el login");

        projectCRUD.addNewProjectButton.click();
        projectCRUD.newProjectTextBox.setText(projectCRUD.projectName);
        projectCRUD.saveNProject.click();
        Thread.sleep(2000);
        Assertions.assertEquals(projectCRUD.projectName, projectCRUD.projectLabel.getTextControl(),"ERROR no se hizo la creacion");
        Assertions.assertTrue(projectCRUD.actualProject.isControlDisplayed(),"ERROR no se hizo la creacion");

        projectCRUD.projectNameBox.click();
        projectCRUD.optionsProjectButton.click();
        projectCRUD.updateProject.click();
        projectCRUD.updateProjectTextBox.clearSetText(projectCRUD.projectUpdateName);
        projectCRUD.saveUpdteButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(projectCRUD.projectUpdateName, projectCRUD.projectLabel.getTextControl(),"ERROR no se hizo update");
        Assertions.assertTrue(projectCRUD.actualProjectUpdate.isControlDisplayed(),"ERROR no se hizo update");

        projectCRUD.projectNameBoxUpdate.click();
        projectCRUD.optionsProjectButton.click();
        projectCRUD.deleteButton.click();
        Thread.sleep(3000);
        projectCRUD.warningPopUp.aceptarWarning();
        Thread.sleep(4000);
        Assertions.assertTrue(!projectCRUD.projectLabel.getTextControl().equals(projectCRUD.projectUpdateName),"ERROR el projecto no se pudo eliminar");







    }
}

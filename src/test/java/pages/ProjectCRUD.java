package pages;

import control.WarningPopUp;
import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectCRUD {

    //CREATE
    public String projectName ="RodrigoViladegut";
    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox newProjectTextBox = new TextBox(By.id("NewProjNameInput"));
    public Button saveNProject = new Button(By.id("NewProjNameButton"));
    public Label projectLabel = new Label(By.id("CurrentProjectTitle"));
    public Label actualProject= new Label(By.xpath("//li[last()]//td[text()='"+ projectName +"']"));

    //UPDATE
    public Button projectNameBox = new Button(By.xpath("//li[last()]//td[text()='"+ projectName +"']"));
    public Button optionsProjectButton = new  Button(By.xpath("//div[@style=\"display: block;\"]/img"));
    public Button updateProject= new Button(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']"));
    public TextBox updateProjectTextBox = new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public String projectUpdateName ="RodrigoVupdate";
    public Button saveUpdteButton = new Button(By.xpath("//td/div/img[@id=\"ItemEditSubmit\"]"));
    public Label actualProjectUpdate= new Label(By.xpath("//li[last()]//td[text()='"+ projectUpdateName +"']"));

    //DELETE
    public Button projectNameBoxUpdate = new Button(By.xpath("//li[last()]//td[text()='"+ projectUpdateName +"']"));
    public Button deleteButton = new Button(By.id("ProjShareMenuDel"));
    public WarningPopUp warningPopUp = new WarningPopUp();


}

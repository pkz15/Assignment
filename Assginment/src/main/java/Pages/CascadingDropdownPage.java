package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CascadingDropdownPage {

    private WebDriver driver;

   
    @FindBy(id = "subject")
    private WebElement subjectDropdown;

    @FindBy(id = "topic")
    private WebElement topicDropdown;

    @FindBy(id = "chapter")
    private WebElement chapterDropdown;

    
    public CascadingDropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize the elements
    }

  
    public void selectSubject(String subject) {
        Select selectSubject = new Select(subjectDropdown);
        try {
        	 selectSubject.selectByVisibleText(subject);
        }
        catch(Exception e)
        {
        	selectSubject.selectByValue(subject);
        }
       
    }

    public void selectTopic(String topic) {
        Select selectTopic = new Select(topicDropdown);
        selectTopic.selectByVisibleText(topic);
    }
    public void selectChapter(String topic) {
        Select selectTopic = new Select(chapterDropdown);
        selectTopic.selectByVisibleText(topic);
    }

    
    public List<WebElement> getTopics() {
        Select selectTopic = new Select(topicDropdown);
        return selectTopic.getOptions();
    }

    
    public List<WebElement> getChapters() {
        Select selectChapter = new Select(chapterDropdown);
        return selectChapter.getOptions();
    }
}

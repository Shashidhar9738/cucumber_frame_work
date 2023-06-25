package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
// i'm telling my eclipse that were is the cucumber class present 
@CucumberOptions(features= {"src/test/java/Simple_books"},glue={"Step_Defination"})
public class Test_runner {

}

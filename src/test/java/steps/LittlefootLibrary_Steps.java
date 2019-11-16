package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.exec.ExecuteException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;
import pages.LittlefootLibraryPage;
import utilities.Config;
import utilities.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LittlefootLibrary_Steps {

LittlefootLibraryPage littlefootLibrary = new LittlefootLibraryPage();



@Given("User is on Littlefoot Library page")
public void user_is_on_Littlefoot_Library_page() {
    Driver.getDriver().get(Config.getProperty("littlefootURL"));
}

@Given("User enters {string}")
public void user_enters(String firstName) {
    littlefootLibrary.firstName.clear();
    littlefootLibrary.firstName.sendKeys(firstName);


}

@Given("User selects {string}")
public void user_selects(String townResident) {
    if(townResident.equalsIgnoreCase("yes")){
        littlefootLibrary.townResidentYes.click();
    }else{
        littlefootLibrary.townResidentNo.click();
    }


}

@And("User puts {string} and {string}")
public void userPutsAnd(String title, String author) {
    littlefootLibrary.title.clear();
    littlefootLibrary.title.sendKeys(title);
    littlefootLibrary.author.clear();
    littlefootLibrary.author.sendKeys(author);
}

@Given("User enters {string}, {string} and {string}")
public void user_enters_and(String pages, String DDC, String readStatus) {
    littlefootLibrary.pages.clear();
    littlefootLibrary.pages.sendKeys(pages);
    littlefootLibrary.dewey_decimal.clear();
    littlefootLibrary.dewey_decimal.sendKeys(DDC);

    Select select = new Select(littlefootLibrary.dropdown);
    select.selectByVisibleText(readStatus);

    int ddc = Integer.parseInt(DDC.substring(0, 1));

    LittlefootLibraryPage.totalPages.putIfAbsent("Computer Science, Information & General Works", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Philosophy & Psychology", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Religion", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Social Sciences", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Language", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Pure Science", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Applied Science", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Arts & Recreation", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Literature", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("History & Geography", 0);
    LittlefootLibraryPage.totalPages.putIfAbsent("Total Pages Read", 0);
    int totalPagesRead = 0;
    if (ddc == 0) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Computer Science, Information & General Works", LittlefootLibraryPage.totalPages.get("Computer Science, Information & General Works") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Computer Science, Information & General Works", LittlefootLibraryPage.totalPages.get("Computer Science, Information & General Works") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 1) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Philosophy & Psychology", LittlefootLibraryPage.totalPages.get("Philosophy & Psychology") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {                                                               //
            LittlefootLibraryPage.totalPages.put("Philosophy & Psychology", LittlefootLibraryPage.totalPages.get("Philosophy & Psychology") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 2) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Religion", LittlefootLibraryPage.totalPages.get("Religion") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Religion", LittlefootLibraryPage.totalPages.get("Religion") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 3) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Social Sciences", LittlefootLibraryPage.totalPages.get("Social Sciences") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Social Sciences", LittlefootLibraryPage.totalPages.get("Social Sciences") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 4) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Language", LittlefootLibraryPage.totalPages.get("Language") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Language", LittlefootLibraryPage.totalPages.get("Language") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 5) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Pure Science", LittlefootLibraryPage.totalPages.get("Pure Science") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Pure Science", LittlefootLibraryPage.totalPages.get("Pure Science") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 6) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Applied Science", LittlefootLibraryPage.totalPages.get("Applied Science") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Applied Science", LittlefootLibraryPage.totalPages.get("Applied Science") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 7) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Arts & Recreation", LittlefootLibraryPage.totalPages.get("Arts & Recreation") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Arts & Recreation", LittlefootLibraryPage.totalPages.get("Arts & Recreation") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 8) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("Literature", LittlefootLibraryPage.totalPages.get("Literature") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("Literature", LittlefootLibraryPage.totalPages.get("Literature") + Integer.valueOf(pages) / 2);
        }
    } else if (ddc == 9) {

        if (readStatus.equals("Read")) {
            LittlefootLibraryPage.totalPages.put("History & Geography", LittlefootLibraryPage.totalPages.get("History & Geography") + Integer.valueOf(pages));

        } else if (readStatus.equals("Partially")) {
            LittlefootLibraryPage.totalPages.put("History & Geography", LittlefootLibraryPage.totalPages.get("History & Geography") + Integer.valueOf(pages) / 2);
        }
    }
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Computer Science, Information & General Works");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Philosophy & Psychology");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Religion");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Social Sciences");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Language");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Pure Science");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Applied Science");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Arts & Recreation");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("Literature");
    totalPagesRead += LittlefootLibraryPage.totalPages.get("History & Geography");
    LittlefootLibraryPage.totalPages.put("Total Pages Read", totalPagesRead);
}

@Then("Librarian gets the report")
public void librarian_gets_the_report() {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("report");
    Cell cell;
    Cell cell2;
    int count = 0;

    for (String a: LittlefootLibraryPage.totalPages.keySet()) {
        Row row = sheet.createRow(count);
        cell = row.createCell(0);
        cell.setCellValue(a);
        cell2 = row.createCell(1);
        cell2.setCellValue(LittlefootLibraryPage.totalPages.get(a));
        count++;
    }

    try{

        FileOutputStream out = new FileOutputStream(new File("data.xlsx"));
        workbook.write(out);
        out.close();

    }catch (ExecuteException e){
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}





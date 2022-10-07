package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLocale extends BaseTestPage{

@Test
    public void setES() throws InterruptedException {
    String expectedResult = "Página de aterrizaje";
    getLocale().setES();
    String actualResult = getLocale().getEsText().getText();
    Assert.assertEquals(actualResult,expectedResult);
}

}

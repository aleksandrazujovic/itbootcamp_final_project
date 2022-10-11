package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLocale extends BaseTest {

@Test
    public void setES() throws InterruptedException {
    String expectedResult = "Página de aterrizaje";

    getLocale().setES();
    String actualResult = getLocale().getEsText().getText();

    Assert.assertEquals(actualResult,expectedResult);
}
@Test
    public void setEN() throws InterruptedException {
    String expectedResult = "Landing";

    getLocale().setEN();
    String actualResult = getLocale().getEsText().getText();

    Assert.assertEquals(actualResult,expectedResult);
}
@Test
    public void setFR() throws InterruptedException {
    String expectedResult = "Page d'atterrissage";

    getLocale().setFR();
    String actualResult = getLocale().getFrText().getText();

    Assert.assertEquals(actualResult,expectedResult);
}


}

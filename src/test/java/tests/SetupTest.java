package tests;

import org.junit.Test;
import utils.Browser;
import utils.utils;

import static org.junit.Assert.assertTrue;

    public class SetupTest extends Base{
        @Test
        public void testOpeningBrowserAndLoadPage(){
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl()));
            System.out.println("Funcionou!");
        }
}

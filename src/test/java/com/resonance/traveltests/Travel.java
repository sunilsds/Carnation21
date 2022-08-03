package com.resonance.traveltests;

import org.testng.annotations.Test;

import com.resonance.config.BaseFramework;
import com.resonance.constants.LocatorType;

import static com.resonance.utility.Keyword.*;

/**
 * 
 * @author Sunil
 *
 */


public class Travel extends BaseFramework {

	@Test
	public void verifyErroronSelectingSameCitiesAsSourceAndDestination() throws InterruptedException {

		waitFor(3000);
		click(LocatorType.xpath, "//button[text(),'x')]");
		click(LocatorType.xpath, "//a[contains(@href,'travel/fli')]");
		waitFor(5000);
		click(LocatorType.xpath, "//label[contains(text(),'From')]/parent::div");
		waitFor(2000);
		click(LocatorType.xpath,
				"//label[contains(text(),'From')]/parent::div/following-sibling::div/descendant::div[contains(text(),'BOM')]");

	}

	@Test
	public void verifySearchResultForShoes() {

	}
}
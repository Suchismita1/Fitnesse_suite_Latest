package com.animana.Fixtures;

public class SeleniumDriverFixture {
	
	private void setBrowser(String browser) {
		
		DefaultWebDriverSupplier defaultWebDriverSupplier = new DefaultWebDriverSupplier();
        defaultWebDriverSupplier.setBrowser(browser);
	}
}

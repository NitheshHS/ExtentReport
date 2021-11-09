package com.sdet.contact;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet.base.BaseClass;
@Listeners(com.sdet.base.ListnerImpl.class)
public class OrganzationTest extends BaseClass{
	
	@Test(groups = {"smoketest"})
	public void TC_ORG_01() {
		//etest.get().info("Inside TC_01");
		System.out.println("Inside TC_01");
		Assert.fail();
	}
	
	@Test(groups= {"regression"})
	public void TC_ORG_02() {
		//test.info("Inside TC_02");
		System.out.println("Inside TC_02");
	}
	@Test(groups = {"regression"})
	public void TC_ORG_03() {
		//test.info("Inside TC_03");
		System.out.println("Inside TC_03");
		//throw new SkipException("Skip the method");
	}
	

}

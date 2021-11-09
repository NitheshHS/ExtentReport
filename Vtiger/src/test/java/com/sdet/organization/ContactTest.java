package com.sdet.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet.base.BaseClass;

@Listeners(com.sdet.base.ListnerImpl.class)
public class ContactTest extends BaseClass{
	
	@Test(groups= {"smoketest"})
	public void TC_CT_01() {
		System.out.println("Inside TC_CT_01");
	}
	
	@Test(groups= {"regression"})
	public void TC_CT_02() {
		System.out.println("Inside TC_CT_02");
		Assert.fail();
	}
	
	@Test(groups= {"smoketest"})
	public void TC_CT_03() {
		System.out.println("Inside TC_CT_03");
	}
	

}

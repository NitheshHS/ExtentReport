package com.testlistner;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet.base.BaseClass;

@Listeners(com.sdet.base.ListnerIMP.class)
public class Testcase1 extends BaseClass{
	
	@Test
	public void tc1() {
		System.out.println("Pass");
	}
	
	@Test
	public void tc2() {
		System.out.println("Fail");
		Assert.fail();
	}
	
	@Test
	public void tc3() {
		System.out.println("Skip");
		throw new SkipException("skipp");
	}

}

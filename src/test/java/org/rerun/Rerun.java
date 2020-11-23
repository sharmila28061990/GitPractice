package org.rerun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Rerun {

	@Test
	public void method1() {
		System.out.println("Method1");}

	@Test
	public void method2() {
		System.out.println("Method2");}

	@Test
	public void method3() {
		Assert.assertTrue(false);
		System.out.println("Method3");}

	@Test
	public void method4() {
		System.out.println("Method4");}

	@Test
	public void method5() {
		System.out.println("Method5");}

	@Test
	public void method6() {
		Assert.assertTrue(false);
		System.out.println("Method6");}
}

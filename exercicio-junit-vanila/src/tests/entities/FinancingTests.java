package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldCreateObjectWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}
	
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 20);
		});
	}
	
	@Test
	public void setTotalAmountShouldSetDataWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		double expectedValue = 80000.00;
		
		f.setTotalAmount(expectedValue);
		
		Assertions.assertEquals(expectedValue, f.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 20);
			
			f.setTotalAmount(101000.0);
		});
	}
	
	@Test
	public void setIncomeShouldSetDataWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		double expectedValue = 2001.0;
		
		f.setIncome(expectedValue);
		
		Assertions.assertTrue(expectedValue == f.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			
			f.setIncome(1999.0);
		});
	}
	
	@Test
	public void setMonthsShouldSetDataWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		int expectedValue = 81;
		
		f.setMonths(expectedValue);
		
		Assertions.assertTrue(expectedValue == f.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			
			f.setMonths(79);
		});
	}
	
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		double expectedValue = 20000.0;
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		double result = f.entry();
		
		Assertions.assertEquals(expectedValue, result);
	}
	
	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		double expectedValue = 1000.0;
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		double result = f.quota();
		
		Assertions.assertTrue(expectedValue == result);
	}
}

package stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;


public class CalculatorStepDefs {
int num1;
int num2;
	int actResult;
	List<Integer> numbers;
	Map<String , Integer> cart;
	int actBill;
	DataTable dataTable;
	
	@Given("I have two numbers {int} and {int}")
	public void i_have_two_numbers_and(int a, int b) {
		// Write code here that turns the phrase above into concrete actions
       num1 = a;
       num2 = b;
	}

	@When("I add those two numbers")
	public void i_add_those_two_numbers() {
		// Write code here that turns the phrase above into concrete actions
actResult = num1 + num2;
	}

	@Then("I should get the result as {int}")
	public void i_should_get_the_result_as(int expResult) {
		// Write code here that turns the phrase above into concrete actions
     Assert.assertEquals(expResult, actResult);
	}

	@When("I sub those two numbers")
	public void i_sub_those_two_numbers() {
	    // Write code here that turns the phrase above into concrete actions
       actResult = num1 - num2;
	}
	@When("I multiply those two numbers")
	public void i_multiply_those_two_numbers() {
	    // Write code here that turns the phrase above into concrete actions
	    
		actResult = num1 * num2;
		System.out.println();
}
	@Given("I have below numbers")
	public void i_have_below_numbers(List<Integer> list1) {
	    this.numbers = list1;
	    System.out.println();
	}

	@When("I add the numbers")
	public void i_add_the_numbers() {
	  for(int num : numbers) {
		  actResult = actResult + num;
	  }
	}
	@Given("Below items are added to the cart")
	public void below_items_are_added_to_the_cart(Map<String , Integer> map1) {
	    this.cart = map1;
	}

	@When("I do the checkout")
	public void i_do_the_checkout() {
	    for(String item : cart.keySet()) {
	    	actBill = actBill + cart.get(item);
	    }
	}

	@Then("Validate the bill is displayed as {int}")
	public void validate_the_bill_is_displayed_as(int expBill) {
	   
		Assert.assertEquals(expBill, actBill);
	}

	@Given("Below items are added to the cart with given quantity")
	public void below_items_are_added_to_the_cart_with_given_quantity(io.cucumber.datatable.DataTable dataTable) {
	   
		this.dataTable = dataTable;
	}

	@When("I do the checkout with given quantity")
	public void i_do_the_checkout_with_given_quantity() {
		
		int rows = dataTable.height();
		
		for(int i=0; i<rows; i++) {
			
			String item = dataTable.cell(i, 0);
			int qnt = Integer.parseInt(dataTable.cell(i, 1));
			int value = Integer.parseInt(dataTable.cell(i, 2));
			
			actBill = actBill + qnt*value;
			
		}
	}

}
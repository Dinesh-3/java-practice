package com.dinesh.design_patterns.behavioural.command1;


import com.dinesh.design_patterns.behavioural.command1.fx.Command;

public class AddCustomerCommand implements Command {
  private CustomerService service;

  public AddCustomerCommand(CustomerService service) {
    this.service = service;
  }

  @Override
  public void execute() {
    service.addCustomer();
  }
}

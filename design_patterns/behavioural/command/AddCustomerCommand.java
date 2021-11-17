package design_patterns.behavioural.command;


import design_patterns.behavioural.command.fx.Command;

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

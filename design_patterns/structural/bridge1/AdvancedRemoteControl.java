package design_patterns.structural.bridge1;

public class AdvancedRemoteControl extends RemoteControl {
  public AdvancedRemoteControl(Device device) {
    super(device);
  }

  public void setChannel(int number) {
    device.setChannel(number);
  }
}

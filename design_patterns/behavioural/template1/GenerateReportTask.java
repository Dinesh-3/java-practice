package design_patterns.behavioural.template1;

public class GenerateReportTask { // Wrong Way
  private AuditTrail auditTrail;

  public GenerateReportTask(AuditTrail auditTrail) {
    this.auditTrail = auditTrail;
  }

  public void execute() {
    auditTrail.record();

    System.out.println("Generate Report");
  }
}

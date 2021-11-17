package DesignPatterns.behavioural.template;

public abstract class Task {
  private AuditTrail auditTrail;

  public Task() {
    auditTrail = new AuditTrail();
  }

  public Task(AuditTrail auditTrail) {
    this.auditTrail = auditTrail;
  }

  public void execute() {
    auditTrail.record();

    doExecute();
  }

  abstract void doExecute();
}

package com.dinesh.design_patterns.behavioural.template1;

public abstract class Task {
  private final AuditTrail auditTrail;

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

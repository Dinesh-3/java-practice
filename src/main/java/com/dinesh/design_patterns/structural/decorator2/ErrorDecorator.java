package com.dinesh.design_patterns.structural.decorator2;

public class ErrorDecorator implements AbstractArtefact {
    private AbstractArtefact artefact;

    protected ErrorDecorator(AbstractArtefact artefact) {
        this.artefact = artefact;
    }

    @Override
    public String render() {
        var mainIcon = artefact.render();
        return mainIcon + " [Error]";
    }
}

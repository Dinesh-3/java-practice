package com.dinesh.design_patterns.behavioural.mediator2;

import java.util.ArrayList;
import java.util.List;

public class UIControl {
    private List<EventHandler> eventHandlers = new ArrayList<>();

    public void addEventHandler(EventHandler handler) {
        eventHandlers.add(handler);
    }

    public void notifyEventHandlers() {
        for (var handler : eventHandlers)
            handler.handle();
    }
}

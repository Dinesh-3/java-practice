package com.dinesh.system_design.load_balancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LeastConnections {
    private Map<String, Integer> serverConnections;

    public LeastConnections(List<String> servers) {
        serverConnections = new ConcurrentHashMap<>();
        for (String server : servers) {
            serverConnections.put(server, 0);
        }
    }

    public String getNextServer() {
        Optional<String> nextServer = serverConnections.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        serverConnections.computeIfPresent(nextServer.get(), (k, v) -> v >= 0 ? v + 1 : 0);
        return nextServer.get();
    }

    public void releaseConnection(String server) {
        serverConnections.computeIfPresent(server, (k, v) -> v > 0 ? v - 1 : 0);
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> servers = List.of("Server1", "Server2", "Server3", "Server4", "Server5");
        LeastConnections leastConnectionsLB = new LeastConnections(servers);

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            Thread thread = new Thread(() -> {
                String server = leastConnectionsLB.getNextServer();
                System.out.println(server);
                try {
                    int sleepTime = (int) (Math.random() * 1000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                leastConnectionsLB.releaseConnection(server);
            });
            thread.start();
        }
    }
}

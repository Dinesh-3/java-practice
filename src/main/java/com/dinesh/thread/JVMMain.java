package com.dinesh.thread;


/**
 *
 * jhsdb jmap --heap --pid 54396
 *
 * jps -> To get all java running processes
 *
 * To generate heap dump on runtime
 * jmap -dump:format=b,file=/tmp/heapdump.hprof 5678
 *
 * Specifying heap dump file path on application start
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/path/to/dumpfile.hprof
 *
 */
public class JVMMain {
    public static void main(String[] args) {

    }
}

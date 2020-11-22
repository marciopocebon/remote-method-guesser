package de.qtc.rmg.server.operations;

import java.io.IOException;

import de.qtc.rmg.server.utils.Utils;
import de.qtc.rmg.server.interfaces.ISslServer;

public class SslServer implements ISslServer {

    public String notRelevant()
    {
        System.out.println("[+]\t[SSL Server]: Processing call for notRelevant()...");
        return "Some irrelevant text...";
    }

    public int execute(String command)
    {
        System.out.println("[+]\t[SSL Server]: Processing call for 'int execute(String command)'...");

        try {
            Process p = java.lang.Runtime.getRuntime().exec(command);
            p.waitFor();
            return p.exitValue();
        }
        catch( Exception e) {}
        return -1;
    }

    public String system(String[] args)
    {
        System.out.println("[+]\t[SSL Server]: Processing call for 'String system(String[] args)'...");
        String result = "";

        try {
            Process p = java.lang.Runtime.getRuntime().exec(args);
            p.waitFor();

            result = Utils.readFromProcess(p);
        } catch( IOException | InterruptedException e) {
            result = "Exception: " + e.getMessage();
        }

        return result;
    }
}
package com.dream.ltl.app.pattern.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {
    private static Map<String,ITicket> pool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from,String to,String bunk){
        String key = from + "->" + to + "|"+bunk;
        if (pool.containsKey(key)){
            System.out.println("use pool: "+key);
            return pool.get(key);
        }
        System.out.println("first create entity");
        ITicket ticket = new TrainTicket(from,to,bunk);
        pool.put(key,ticket);
        return ticket;
    }
}

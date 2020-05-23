package com.dream.ltl.app.pattern.flyweight;

import com.dream.ltl.app.pattern.flyweight.ticket.ITicket;
import com.dream.ltl.app.pattern.flyweight.ticket.TicketFactory;

public class App {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("济南西","上海","二等座");
        ticket.showInfo();
        ITicket ticket1 = TicketFactory.queryTicket("济南西","上海","二等座");
        ticket.showInfo();
        ITicket ticket2 = TicketFactory.queryTicket("济南西","上海虹桥","二等座");
        ticket.showInfo();
    }
}

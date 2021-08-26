package com.epam.jwd.controller;

import com.epam.jwd.model.Logic;
import com.epam.jwd.view.Output;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        Output.output("Print text: ");
        logic.print();
    }

}

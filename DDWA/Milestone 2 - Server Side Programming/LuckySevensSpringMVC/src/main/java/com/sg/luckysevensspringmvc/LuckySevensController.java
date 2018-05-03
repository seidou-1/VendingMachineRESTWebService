/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author laptop
 */
@Controller //Let's the Handler Mapping know that this "component" is responsible for procesing this request
public class LuckySevensController {

    @RequestMapping(value = "/luckySevens", method = RequestMethod.POST) // 'luckySevens' is obtained from the "action" within the form submission

    public String luckySevens(HttpServletRequest request, Map<String, Object> model) {

        /*
    The string returns the logical view name and hand that back to the Spring MVC Framework (i.e. return "result")
    We need to pass the HttpServletRequest to see what was set on that form. So we will look at the requet paramater
    We no longer need the request attribute. Instead we use the model object which is in the form of a map
         */
        String userInput = request.getParameter("userCash");
        int userCash = Integer.parseInt(userInput);
        int rollCount = 0;
        int maxCash = 0;
        int winningRolls = 0;

        while (userCash != 0) {
            Random randomizer = new Random();

            int dice1 = randomizer.nextInt(7) + 1;
            int dice2 = randomizer.nextInt(7) + 1;
            int totalRoll = dice1 + dice2;

            if (totalRoll == 7) {
                userCash += 4;
                maxCash += 4;
                rollCount++;
                winningRolls++;

            } else {
                rollCount++;
                userCash--;
            }
        }

        model.put("userInput", userInput);
        model.put("maxCash", maxCash);
        model.put("winningRolls", winningRolls);
        model.put("rollCount", rollCount);

        return "result";

    }

}

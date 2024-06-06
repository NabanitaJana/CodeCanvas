package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        try{
            if(tokens.size()==2 && "LEADERBOARD".equals(tokens.get(0))){
                String order=tokens.get(1).toUpperCase();
                ScoreOrder scoreOrder=ScoreOrder.valueOf(order);
                List<User>userlist=userService.getAllUserScoreOrderWise(scoreOrder);
                System.out.println(userlist);
            }
            else{
                System.out.println("Invalid command for leaderboard");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("error: invalid scoreorder. Use ASC or DSC" );
        }
        catch(Exception e){
            System.out.println("unexpected error occured");
            e.printStackTrace();
        }
    }
    
}

package ga.sma;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentContainer;

import java.util.Random;

public class IndividualAgent extends Agent {
    public static final int MAX_FITNESS=5;
    private int genes[]=new int[5];
    private int fitness;
    Random random=new Random();
    @Override
    protected void setup() {
        //calculate fitness
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                fitness=0;
                for(int gene: genes){
                    fitness+=gene;
                }
            }
        });
        AgentContainer agentContainer=getContainerController();
        //mutation
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                int index = random.nextInt(6);
                if (genes[index] == 1)
                    genes[index] = 0;
                else
                    genes[index] = 1;
            }
        });
    }
}

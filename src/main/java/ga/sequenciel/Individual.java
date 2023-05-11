package ga.sequenciel;

import java.util.Random;

public class Individual implements Comparable {
    //chromosome
    char[] genes;
    char[] goal= {'b','o','n','j','o','u','r'};
    char[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private int[] fitness;
    private int sumFitness=0;

    public Individual(){
        Random rnd=new Random();
        genes=new char[goal.length];
        fitness=new int[goal.length];

        for(int i = 0; i< goal.length; i++){
            genes[i]=alphabet[rnd.nextInt(25)];
        }
    }
    public void calculateFitness(){
        sumFitness=0;
        for(int i = 0; i< genes.length; i++){
            if(Math.abs(genes[i]-goal[i])!=0)
                fitness[i]= 1;
            else
                fitness[i]= 0;
            sumFitness+=fitness[i];
        }
    }
    public void calculateFitness2(){
        sumFitness=0;
        for(int i = 0; i< genes.length; i++){
            fitness[i]= Math.abs(genes[i]-goal[i]);
            sumFitness+=fitness[i];
        }
    }
    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o;

        if(this.sumFitness>individual.sumFitness)
            return 1;
        else if (this.sumFitness<individual.sumFitness)
            return -1;
        return 0;
    }


    public int[] getFitness() {
        return fitness;
    }

    public void setGenes(char[] genes) {
        this.genes = genes;
    }

    public void setFitness(int[] fitness) {
        this.fitness = fitness;
    }

    public char[] getGenes() {
        return genes;
    }

    public int getSumFitness() {
        return sumFitness;
    }
}

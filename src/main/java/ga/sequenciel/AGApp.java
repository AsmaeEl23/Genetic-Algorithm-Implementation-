package ga.sequenciel;

import java.util.Arrays;
import java.util.Random;

public class AGApp {
    private static final int MAX_IT=1000;
    private  static final int MAX_FITNESS=10;
    private static final char[] goal= {'b','o','n','j','o','u','r'};
    public static void main(String[] args) {
        Population population=new Population();
        population.initializePopulation();
        population.calculateIndividualFitness();
        population.sortPopulation();
 /*       //show fitness
        for(int i=0;i<population.individuals.size();i++){
            System.out.println(i+" Chromosome : "+ Arrays.toString(population.individuals.get(i).getGenes())+" fitness : "+population.individuals.get(i).getSumFitness());
            for(int j = 0; j< population.individuals.get(i).getGenes().length; j++) {
                System.out.println("g " + population.individuals.get(i).getGenes()[j] + " goal " + goal[j] + " fitness " + population.individuals.get(i).getFitness()[j]);
            }
        }

        population.selection();
        population.crossover();
        population.sortPopulation();
        for(int i=0;i<population.individuals.size();i++){
            System.out.println(i+" Chromosome : "+ Arrays.toString(population.individuals.get(i).getGenes())+" fitness : "+population.individuals.get(i).getSumFitness());
            for(int j = 0; j< population.individuals.get(i).getGenes().length; j++) {
                System.out.println("g " + population.individuals.get(i).getGenes()[j] + " goal " + goal[j] + " fitness " + population.individuals.get(i).getFitness()[j]);
            }
        }

        population.mutation();
        for(int i=0;i<population.individuals.size();i++){
            System.out.println(i+" Chromosome : "+ Arrays.toString(population.individuals.get(i).getGenes())+" fitness : "+population.individuals.get(i).getSumFitness());
            for(int j = 0; j< population.individuals.get(i).getGenes().length; j++) {
                System.out.println("g " + population.individuals.get(i).getGenes()[j] + " goal " + goal[j] + " fitness " + population.individuals.get(i).getFitness()[j]);
            }
        }
 */
      ///*
        int it=0;
        while (it<MAX_IT || population.getBestFitnessInd().getSumFitness()>MAX_FITNESS){
            System.out.println("---------------------------iteration-"+it+"-------------------------------------");
            population.selection();
            population.crossover();
            population.calculateIndividualFitness();
            population.sortPopulation();
            Random random=new Random();
            if(random.nextInt(101)<50){
                System.out.println("mutation");
                population.mutation();
            }
            population.calculateIndividualFitness();
            population.sortPopulation();
            for(int i=0;i<population.individuals.size();i++){
                //for(int k = 0; k< population.individuals.get(i).getGenes().length; k++) {
                  //  System.out.println(i+"g " + population.individuals.get(i).getGenes()[k] + " goal " + goal[k] + " fitness " + population.individuals.get(i).getFitness()[k]);
                //}
                System.out.println(i+" Chromosome : "+ Arrays.toString(population.individuals.get(i).getGenes())+" fitness : "+population.individuals.get(i).getSumFitness()+" fitness "+Arrays.toString(population.individuals.get(i).getFitness()));
            }
            it++;
        }
         //*/
    }
}

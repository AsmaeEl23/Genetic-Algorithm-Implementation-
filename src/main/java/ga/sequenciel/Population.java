package ga.sequenciel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Population {
    private static final int MAX_IND = 5;
    List<Individual> individuals = new ArrayList<>();
    Individual firstFinest;
    Individual secondFinest;
    Random random = new Random(4);

    public void initializePopulation() {
        for (int i = 0; i < MAX_IND; i++) {
            individuals.add(new Individual());
        }
    }

    public void calculateIndividualFitness() {
        for (int i = 0; i < MAX_IND; i++) {
            individuals.get(i).calculateFitness();
        }
    }

    public void selection() {
        firstFinest = individuals.get(0);
        secondFinest = individuals.get(1);
    }

    public void sortPopulation() {
        Collections.sort(individuals);
    }

    //croisement
    public void crossover() {
        int pointCroisement = random.nextInt(MAX_IND-3);
        pointCroisement+=2;
        //System.out.println("___pointCroisement : "+pointCroisement);
        Individual individual1 = new Individual();
        Individual individual2 = new Individual();
        String ind1="";
        String ind2="";
        for (int i = 0; i < individual2.getGenes().length; i++) {
            individual1.getGenes()[i] = firstFinest.getGenes()[i];
            ind1+=individual1.getGenes()[i];
            individual2.getGenes()[i] = secondFinest.getGenes()[i];
            ind2+=individual2.getGenes()[i];
        }
        //System.out.println("ind1 "+ind1);
        //System.out.println("ind2 "+ind2);

        for (int i = 0; i < pointCroisement; i++) {
            individual1.getGenes()[i] = secondFinest.getGenes()[i];
            individual2.getGenes()[i] = firstFinest.getGenes()[i];
        }
        individuals.set(individuals.size() - 1, individual1);
        individuals.set(individuals.size() - 2, individual2);
        individual1.calculateFitness();
        individual2.calculateFitness();
    }

    public void mutation() {
        int index = random.nextInt(individuals.get(0).goal.length);
        while(individuals.get(individuals.size() - 1).getFitness()[index] ==0){
            index = random.nextInt(individuals.get(0).goal.length);
        }
        if (individuals.get(individuals.size() - 1).getFitness()[index] !=0){
            char newAlpha=individuals.get(0).alphabet[random.nextInt(24)];
            while(individuals.get(individuals.size() - 1).getGenes()[index]==newAlpha){
                newAlpha=individuals.get(0).alphabet[random.nextInt(24)];
            }
            System.out.println(newAlpha+" "+individuals.get(individuals.size() - 1).getGenes()[index]);
            individuals.get(individuals.size() - 1).getGenes()[index] = newAlpha;
            individuals.get(individuals.size() - 1).calculateFitness();
        }
    }

    public Individual getBestFitnessInd() {
        return individuals.get(0);
    }
}

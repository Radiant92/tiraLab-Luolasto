package cave.domain;

import cave.util.MyList;
import java.util.Random;

/**
 * The CaveMapper class provides functions for generating main caves and
 * sub-caves.
 *
 * mainCaves: generates the main caves by making sure that every level has at
 * the least one cave.
 *
 * subCaves: These are the lesser caves that are either adjacent to each other
 * or to a main cave. Sub caves are randomised by randomly checking which cave
 * in the cavern has an empty sleeve next, above or below it and randomly
 * choosing one of these directions to place the next sub room.
 *
 * @author strohm
 */
public class CaveMapper {

    Random random;
    MyList<Sleeve> needNeighbours;
    MyList<Integer> habitedSleeves;
    Sleeve s;
    int deep;

    public CaveMapper(int deep) {
        s = new Sleeve(-1);
        this.random = new Random();
        this.needNeighbours = new MyList<Sleeve>(s);
        this.habitedSleeves = new MyList<Integer>(1);
        this.deep = deep;
    }

    /**
     * This method generates the main-cavern, by building a spine-like structure
     * by choosing at least 1 room per level and a random amount of adjacent
     * main rooms.
     *
     * @return A List of main-caves
     */
    public MyList mainCaves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s);
        Sleeve important = s;
        for (int i = 5; i < deep; i += 10) {
            int defSleeve = random.nextInt(3) - 2 + i;
            Sleeve mainSleeve = new Sleeve(defSleeve);
            sleeves.addSleeve(mainSleeve);
            habitedSleeves.addInteger(defSleeve);
            needNeighbours.addSleeve(sleeves.getSleeve(sleeves.size() - 1));
            if (i > 10) {
                mainSleeve.getRoom().addAppendage(important.getRoom());
            }
            important = mainSleeve;
            for (int k = 3; k < 6; k++) {
                if (random.nextInt(20) % 5 == 0 && k != defSleeve) {
                    Sleeve lesserSleeve = new Sleeve(i + k);
                    sleeves.addSleeve(lesserSleeve);
                    important.getRoom().addAppendage(lesserSleeve.getRoom());
                    habitedSleeves.addInteger(i + k);
                    needNeighbours.addSleeve(sleeves.getSleeve(sleeves.size() - 1));
                }
            }
        }
        return sleeves;
    }

    /**
     * This method is responsible for generating the sub-cavern by randomly
     * choosing vacant adjacent sleeves, and adding to that list as more caves
     * are generated.
     *
     * @return List of sub-Caves.
     */
    public MyList subCaves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s);

        for (int i = 0; i < deep / 4; i++) {
            int sleeveIndex = random.nextInt(needNeighbours.size());
            Sleeve sleeve = needNeighbours.getSleeve(sleeveIndex);
            MyList<Integer> freeSleeves = getNeighbouringFreeSleeves(sleeve.getNumber());

            if (freeSleeves.size() == 0) {
                needNeighbours.remove(sleeveIndex);
                i--;
                continue;
            }
            Sleeve newSleeve = chooseSleeve(freeSleeves);
            sleeve.getRoom().addAppendage(newSleeve.getRoom());
            sleeves.addSleeve(newSleeve);
            needNeighbours.addSleeve(newSleeve);
        }
        return sleeves;
    }

    /**
     *
     * @param number of the sleeve that is being checked for vacant neighbouring
     * Sleeves.
     * @return numbers of vacant surrounding sleeves.
     */
    public MyList getNeighbouringFreeSleeves(int number) {
        MyList<Integer> sleeveNumbers = new MyList<Integer>(1);
        if (number > 9) {
            if (isEmptySleeve(number - 10)) {
                sleeveNumbers.addInteger(number - 10);
            }
        }
        if (number < 90) {
            if (isEmptySleeve(number + 10)) {
                sleeveNumbers.addInteger(number + 10);
            }
        }
        if (number % 10 != 0) {
            if (isEmptySleeve(number - 1)) {
                sleeveNumbers.addInteger(number - 1);
            }
        }
        if (number % 10 != 9) {
            if (isEmptySleeve(number + 1)) {
                sleeveNumbers.addInteger(number + 1);
            }
        }
        return sleeveNumbers;
    }

    /**
     *
     * @param number corresponding Sleeve
     * @return if said Sleeve is vacant
     */
    public boolean isEmptySleeve(int number) {
        if (habitedSleeves.contains(number)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param sleeveNumbers available vacant sleeves.
     * @return The new Sleeve that was created
     */
    public Sleeve chooseSleeve(MyList<Integer> sleeveNumbers) {
        int number = sleeveNumbers.getInteger(random.nextInt(sleeveNumbers.size()));
        habitedSleeves.addInteger(number);
        return new Sleeve(number);
    }
}

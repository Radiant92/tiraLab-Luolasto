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
    /**
     * Pool of sleeves that can be given neighbours.
     */
    MyList<Sleeve> sleevesThatNeedNeighbours;
    /**
     * Sleeves that are already inhabited (no need for slow contains method).
     */
    int[] sleevesThatHaveARoom;
    /**
     * Sleeves that have no room for new neighbours.
     */
    int[] sleevesThatDontHaveRoomForNeighbours;
    /**
     * for the creation of Sleeve lists and such, this Sleeve will not be used
     * for any Room.
     */
    Sleeve defaultSleeve;
    /**
     * represents the depth of the cavern as in how many sleeve units can fit.
     */
    int depthOfTheCavern;

    /**
     * Constructs the Mapper for the cavern. Sets up all the neccissary lists
     * and tables to build two lists of caverns.
     *
     * @param depth how deep the cavern will be.
     */
    public CaveMapper(int depth) {
        sleevesThatDontHaveRoomForNeighbours = new int[depth + 1];
        defaultSleeve = new Sleeve(-1);
        this.random = new Random();
        this.sleevesThatNeedNeighbours = new MyList<>(defaultSleeve, depth);
        this.sleevesThatHaveARoom = new int[depth + 10];
        this.depthOfTheCavern = depth;

    }

    /**
     * This method generates the main-cavern, by building a spine-like structure
     * by choosing at least 1 room per level and a random amount of adjacent
     * main rooms.
     *
     * Time complexity O(3n), because sleeves size is equal to depth so no
     * doubleSize can happen.
     *
     * @return A List of main-caves
     */
    public MyList mainCaves() {
        MyList<Sleeve> sleeves = new MyList<>(defaultSleeve, depthOfTheCavern);
        Sleeve mainPathSleeve = createNewSleeve(5);
        sleeves.addSleeve(mainPathSleeve);

        for (int i = 15; i < depthOfTheCavern; i += 10) {
            Sleeve mainSleeve = createNewSleeve(random.nextInt(3) - 2 + i);
            sleeves.addSleeve(mainSleeve);
            mainPathSleeve.getRoom().addAppendage(mainSleeve.getRoom());

            mainPathSleeve = mainSleeve;

            for (int k = 3; k < 6; k++) {
                if (random.nextInt(20) % 5 == 0 && k != mainPathSleeve.getNumber()) {
                    Sleeve lesserSleeve = createNewSleeve(i + k);
                    mainPathSleeve.getRoom().addAppendage(lesserSleeve.getRoom());
                    sleeves.addSleeve(lesserSleeve);
                }
            }
        }
        return sleeves;
    }

    /**
     * Creates a sleeve and adds it to the sleeve pools.
     *
     * @param numberForNewSleeve the number of the sleeve
     * @return the new Sleeve that was created.
     */
    public Sleeve createNewSleeve(int numberForNewSleeve) {

        Sleeve sleeve = new Sleeve(numberForNewSleeve);
        sleevesThatHaveARoom[numberForNewSleeve] = 1;
        sleevesThatNeedNeighbours.addSleeve(sleeve);
        return sleeve;
    }

    /**
     * This method is responsible for generating the sub-cavern by randomly
     * choosing vacant adjacent sleeves, and adding to that list as more caves
     * are generated. The amount of rooms has been limited to 25 percent of the
     * depth.
     *
     * Time complexity O(n)
     *
     * @return List of sub-Caves.
     */
    public MyList subCaves() {
        MyList<Sleeve> sleeves = new MyList<>(defaultSleeve, depthOfTheCavern / 4 + 100);
        for (int i = 0; i < depthOfTheCavern / 4; i++) {
            int sleeveIndex = random.nextInt(sleevesThatNeedNeighbours.size());

            if (sleevesThatDontHaveRoomForNeighbours[sleeveIndex] == 1) {
                i--;
                continue;
            }

            Sleeve sleeve = sleevesThatNeedNeighbours.getSleeve(sleeveIndex);
            MyList<Integer> freeSleeves = getNeighbouringFreeSleeves(sleeve.getNumber());

            if (freeSleeves.size() == 0) {
                sleevesThatDontHaveRoomForNeighbours[sleeveIndex] = 1;
                i--;
                continue;
            }
            Sleeve newSleeve = createNewSleeve(chooseSleeve(freeSleeves));
            sleeve.getRoom().addAppendage(newSleeve.getRoom());
            sleeves.addSleeve(newSleeve);

        }
        return sleeves;
    }

    /**
     * Time complexity O(1)
     *
     * @param number of the sleeve that is being checked for vacant neighbouring
     * Sleeves.
     * @return numbers of vacant surrounding sleeves.
     */
    public MyList getNeighbouringFreeSleeves(int number) {
        MyList<Integer> sleeveNumbers = new MyList<>(1, 10);
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
     * Time complexity O(1)
     *
     * @param number corresponding Sleeve
     * @return if said Sleeve is vacant
     */
    public boolean isEmptySleeve(int number) {
        if (sleevesThatHaveARoom[number] == 1) {
            return false;
        }
        return true;
    }

    /**
     * Time complexity O(1)
     *
     * @param sleeveNumbers available vacant sleeves.
     * @return The new Sleeve number that was chosen
     */
    public Integer chooseSleeve(MyList<Integer> sleeveNumbers) {
        return sleeveNumbers.getInteger(random.nextInt(sleeveNumbers.size()));

    }
}

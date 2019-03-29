
package cave.domain;

import java.util.*;

/**
 * The CaveMapper class provides functions for generating main caves and 
 * sub-caves.
 * 
 * mainCaves: generates the main caves by making sure that every level has 
 * at the least one cave.
 * 
 * subCaves: These are the lesser caves that are either adjecent to eachother
 * or to a main cave. Sub caves are randomized by randomly checking which cave
 * in the cavern has an empty sleeve next, above or below it and randomly 
 * choosing one of these directions to place the next sub room.
 * 
 * @author strohm
 */
public class CaveMapper {

    Random random;
    List<Sleeve> needNeighbours;
    List<Integer> habitedSleeves;
    int deep;

    public CaveMapper(int deep) {
        this.random = new Random();
        this.needNeighbours = new ArrayList<>();
        this.habitedSleeves = new ArrayList<>();
        this.deep = deep;
    }

    public List mainCaves() {
        List<Sleeve> sleeves = new ArrayList<>();

        for (int i = 5; i < deep; i += 10) {
            int defRoom = random.nextInt(3) - 2 + i;
            sleeves.add(new Sleeve(defRoom));
            habitedSleeves.add(defRoom);
            needNeighbours.add(sleeves.get(sleeves.size() - 1));
            for (int k = 3; k < 6; k++) {
                if (random.nextInt(20) % 10 == 0 && k != defRoom) {
                    sleeves.add(new Sleeve(i + k));
                    habitedSleeves.add(i + k);
                    needNeighbours.add(sleeves.get(sleeves.size() - 1));
                }
            }
        }
        return sleeves;
    }

    public List subCaves() {
        List<Sleeve> sleeves = new ArrayList();

        for (int i = 0; i < deep / 4; i++) {
            int sleeveIndex = random.nextInt(needNeighbours.size());
            Sleeve sleeve = needNeighbours.get(sleeveIndex);
            List<Integer> freeSleeves = getNeighbouringFreeSleeves(sleeve.getNumber());

            if (freeSleeves.size() == 0) {
                needNeighbours.remove(sleeveIndex);
                i--;
                continue;
            }
            sleeves.add(chooseSleeve(freeSleeves));
            needNeighbours.add(sleeves.get(sleeves.size() - 1));
        }
        return sleeves;
    }

    public List getNeighbouringFreeSleeves(int number) {
        List sleeveNumbers = new ArrayList();
        if (number > 9) {
            if (isEmptySleeve(number - 10)) {
                sleeveNumbers.add(number - 10);
            }
        }
        if (number < 90) {
            if (isEmptySleeve(number + 10)) {
                sleeveNumbers.add(number + 10);
            }
        }
        if (number % 10 != 0) {
            if (isEmptySleeve(number - 1)) {
                sleeveNumbers.add(number - 1);
            }
        }
        if (number % 10 != 9) {
            if (isEmptySleeve(number + 1)) {
                sleeveNumbers.add(number + 1);
            }
        }
        return sleeveNumbers;
    }

    public boolean isEmptySleeve(int number) {
        if (habitedSleeves.contains(number)) {
            return false;
        }
        return true;
    }

    public Sleeve chooseSleeve(List<Integer> sleeveNumbers) {
        int number = sleeveNumbers.get(random.nextInt(sleeveNumbers.size()));
        habitedSleeves.add(number);
        return new Sleeve(number);
    }
}

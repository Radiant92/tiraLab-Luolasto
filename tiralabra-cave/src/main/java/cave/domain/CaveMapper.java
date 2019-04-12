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

    public MyList mainCaves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s);

        for (int i = 5; i < deep; i += 10) {
            int defRoom = random.nextInt(3) - 2 + i;
            sleeves.addSleeve(new Sleeve(defRoom));
            habitedSleeves.addInteger(defRoom);
            needNeighbours.addSleeve(sleeves.getSleeve(sleeves.size() - 1));
            for (int k = 3; k < 6; k++) {
                if (random.nextInt(20) % 10 == 0 && k != defRoom) {
                    sleeves.addSleeve(new Sleeve(i + k));
                    habitedSleeves.addInteger(i + k);
                    needNeighbours.addSleeve(sleeves.getSleeve(sleeves.size() - 1));
                }
            }
        }
        return sleeves;
    }

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
            sleeves.addSleeve(chooseSleeve(freeSleeves));
            needNeighbours.addSleeve(sleeves.getSleeve(sleeves.size() - 1));
        }
        return sleeves;
    }

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

    public boolean isEmptySleeve(int number) {
        if (habitedSleeves.contains(number)) {
            return false;
        }
        return true;
    }

    public Sleeve chooseSleeve(MyList<Integer> sleeveNumbers) {
        int number = sleeveNumbers.getInteger(random.nextInt(sleeveNumbers.size()));
        habitedSleeves.addInteger(number);
        return new Sleeve(number);
    }
}

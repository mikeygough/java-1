public class Birthday {
    public static void main(String[] args) {
        // Choose a birthday for the next person, uniformly at random between 0 and n−1.
        // Have that person enter the room.
        // If that person shares a birthday with someone else in the room, stop; otherwise repeat.

        // get n
        int n = Integer.parseInt(args[0]);
        // get trials
        double numTrials = Double.parseDouble(args[1]);

        // initialize trial results array
        int[] trialResults = new int[(int) numTrials];
        // run simulation
        for (int t = 0; t < numTrials; t++) {
            // set room.
            int[] room = new int[n + 1];
            // populate room with random birthdays
            for (int i = 0; i < room.length; i++) {
                room[i] = (int) (Math.random() * (n - 1));
            }
            // check for duplicate birthdays
            int numPeople = 0;
            for (int i = 0; i < room.length; i++) {
                if (numPeople == 0) {
                    for (int j = 0; j <= i; j++) {
                        if (room[i] == room[j] && i != j) {
                            numPeople = i;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            trialResults[t] = numPeople;
        }

        // add count of people it took to have matching birthday
        int[] numPeople = new int[n];
        for (int i = 0; i < n; i++) {
            int peopleCount = 0;
            for (int j = 0; j < trialResults.length; j++) {
                if (i == trialResults[j]) {
                    peopleCount += 1;
                }
            }
            numPeople[i] = peopleCount;
        }

        double rollingSum = 0;
        for (int i = 0; i < numPeople.length; i++) {
            rollingSum += numPeople[i];
            if (rollingSum / numTrials < 0.50) {
                System.out.print(i + 1 + "    ");
                System.out.print(numPeople[i] + "    ");
                System.out.print(rollingSum / numTrials);
                System.out.println();
            } else if (rollingSum / numTrials >= 0.50) {
                System.out.print(i + 1 + "    ");
                System.out.print(numPeople[i] + "    ");
                System.out.print(rollingSum / numTrials);
                System.out.println();
                break;
            }
        }
    }
}

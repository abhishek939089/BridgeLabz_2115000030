public class CircularTour {
    public int findStartingPoint(int[] fuel, int[] distance) {
        int start = 0, deficit = 0, surplus = 0;

        for (int i = 0; i < fuel.length; i++) {
            surplus += fuel[i] - distance[i];
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        if (surplus + deficit >= 0) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        CircularTour tour = new CircularTour();
        int[] fuel = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(tour.findStartingPoint(fuel, distance));
    }
}

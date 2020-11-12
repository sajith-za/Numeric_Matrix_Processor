class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        minutes++;
        minutes = minutes % 60;

        if (minutes == 0) {
            hours++;
            hours = hours % 12;

            if (hours == 0) {
                hours = 12;
            }
        }

    }
}

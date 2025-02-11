class Movie {
    String title, director;
    int year;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = this.next = null;
    }
}

class MovieList {
    Movie head, tail;

    void addMovie(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addMovie(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    void removeMovie(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Movie removed: " + title);
    }

    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by " + director);
    }

    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating + " or higher.");
    }

    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated " + title + " to new rating: " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie temp = head;
        System.out.println("\nMovies (Forward Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        Movie temp = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addMovie("Inception", "Christopher Nolan", 2010, 8.8);
        list.addMovie("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addMovieAtBeginning("The Matrix", "Wachowski", 1999, 8.7);
        list.addMovieAtPosition("Avatar", "James Cameron", 2009, 7.9, 2);

        list.displayMoviesForward();
        list.displayMoviesReverse();

        list.removeMovie("Avatar");

        list.displayMoviesForward();

        list.searchByDirector("Christopher Nolan");

        list.searchByRating(8.0);

        list.updateRating("Interstellar", 9.0);

        list.displayMoviesForward();
    }
}

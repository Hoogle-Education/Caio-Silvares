import model.Film;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("avengers", "marvel heroes");
        Film film2 = new Film("spyder man", "new marvel super hero");
        Film film3 = Film.generateGenericMarvelRandomMovie();
        Film film4 = Film.generateGenericMarvelRandomMovie();
        Film film5 = Film.generateGenericMarvelRandomMovie();


        System.out.println(film1);
        System.out.println(film2);
        System.out.println(film3);
        System.out.println(film4);
        System.out.println(film5);


    }
}
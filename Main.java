import java.util.Scanner;
import java.util.ArrayList;

static void main() {
    Scanner sc = new Scanner(System.in);
    //ratings
    ArrayList<Integer> ratings = new ArrayList<>();
    ratings.add(89);
    ratings.add(77);
    ratings.add(77);
    ratings.add(22);
    ratings.add(59);
    //song names
    ArrayList<String> names = new ArrayList<>();
    names.add("Royals");
    names.add("Viva la Vida");
    names.add("Never really Over");
    names.add("Drop Dead");
    names.add("Boomerang");
    //artists
    ArrayList<String> artists = new ArrayList<>();
    artists.add("Lorde");
    artists.add("Coldplay");
    artists.add("Kate Perry");
    artists.add("Olivia Rodrigo");
    artists.add("Imagine Dragons");

    boolean loopCondition = true;
    System.out.println("Welcome to the MLM!");
    //This is the main framework of the MLM
    while (loopCondition) {
        double averageRating = 0;

        System.out.println("Menu\n1. Add a song\n2. Average rating of the library\n3. Minimum and Maximum rated song\n4. Display the list of songs\n5. Display the Rating Distribution\n6. Search a song\n7. Display the top and bottom 20%\n8. Exit the program\nYour Option:");
        switch(sc.nextLine()) {
            //case 1 is adding songs
            case "1":
                int counter = 0;
                while (true) {
                    System.out.println("Enter the name of the song:");
                    names.add(sc.nextLine());
                    System.out.println("Enter the artist name:");
                    artists.add(sc.nextLine());
                    System.out.println("Enter the rating of the song:");
                    ratings.add(Integer.parseInt(sc.nextLine()));
                    counter ++;
                    if (counter == 2) {
                        break;
                    } else {
                        System.out.println("Do you want to add another song? : ");
                        String option = sc.nextLine().toLowerCase();
                        if (option.equals("no")) {
                            break;
                        }
                    }
                }

                System.out.println("----------------------------------------------------------------------");
                break;

            //case 2 is finding the average rating
            case "2":
                double sum = 0;
                for (int i = 0; i < ratings.size(); i ++) {
                    sum += ratings.get(i);
                }
                averageRating = sum/ratings.size();
                System.out.println(String.format("The average rating of the library is %.1f", averageRating));
                System.out.println("----------------------------------------------------------------------");
                break;

            //case 3 is finding the Min and Max rated songs
            case "3":
                int max = Integer.MIN_VALUE;
                int maxRatedSongIndex = 0;
                int min = Integer.MAX_VALUE;
                int minRatedSongIndex = 0;
                for (int i = 0; i < ratings.size(); i ++) {
                    int current = ratings.get(i);
                    if (current > max) {
                        max = current;
                        maxRatedSongIndex = i;
                    }

                    if (current < min) {
                        min = current;
                        minRatedSongIndex = i;
                    }
                }
                System.out.println("The highest rated song is: \n"+ names.get(maxRatedSongIndex) + "\n" + artists.get(maxRatedSongIndex) + "\n" + ratings.get(maxRatedSongIndex));
                System.out.println("The lowest rated song is: \n"+ names.get(minRatedSongIndex) + "\n" + artists.get(minRatedSongIndex) + "\n" + ratings.get(minRatedSongIndex));
                System.out.println("----------------------------------------------------------------------");
                break;

            //case 4 is Display the list of songs
            case "4":
                for (int i = 0; i < names.size(); i ++) {
                    System.out.println("ID: " + i);
                    System.out.println("Song: " + names.get(i));
                    System.out.println("Artist: " + artists.get(i));
                    System.out.println("Rating: " + ratings.get(i));
                    System.out.println("----------------------------------------------------------------------");
                }

                System.out.println("a. Edit A Song  \nb. Remove A Song  \nc.Return to the main menu");
                String response = sc.nextLine().toLowerCase();
                switch(response) {
                    case "a":
                        //edit a song
                        System.out.println("Enter the ID number for the song which you want to change: ");
                        int editSong = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter the edited song name:");
                        names.set(editSong, sc.nextLine());
                        System.out.println("Enter the edited artist name:");
                        artists.set(editSong, sc.nextLine());
                        System.out.println("Enter the edited rating name:");
                        ratings.set(editSong, Integer.parseInt(sc.nextLine()));
                        break;
                    case "b":
                        //this removes a song
                        System.out.println("Enter the ID number for the song which you want to remove");
                        int removedSong = Integer.parseInt(sc.nextLine());
                        names.remove(removedSong);
                        artists.remove(removedSong);
                        ratings.remove(removedSong);
                        break;
                    case "c":
                        //this return to the main menu
                        System.out.println("return to the main menu");
                        break;
                    default:
                        System.out.println("Invalid input. return to the main menu");
                        break;
                }
                System.out.println("----------------------------------------------------------------------");
                break;

            //case 5 is display the rating distribution
            case "5":
                //this initializes the rating
                int level5 = 0;
                int level4 = 0;
                int level3 = 0;
                int level2 = 0;
                int level1 = 0;

                //This records how many songs are in each rating categories
                for (int i = 0; i < ratings.size(); i ++) {
                    int current = ratings.get(i);
                    if (current >= 90) {
                        level5 ++;
                    } else if (current >= 75) {
                        level4 ++;
                    } else if (current >= 60) {
                        level3 ++;
                    } else if (current >= 40) {
                        level2 ++;
                    } else {
                        level1 ++;
                    }
                }

                //this finds the number of repetition
                int maxNumberRating = Math.max(level1, level2);
                maxNumberRating = Math.max(maxNumberRating, level3);
                maxNumberRating = Math.max(maxNumberRating, level4);
                maxNumberRating = Math.max(maxNumberRating, level5);
                //this print the rating distribution
                for (int i = maxNumberRating; i >= 1; i --) {
                    if (i <= level5) {
                        System.out.print("\u25A0" + " ");
                    } else {
                        System.out.print("  ");
                    }

                    if (i <= level4) {
                        System.out.print("\u25A0" + " ");
                    } else {
                        System.out.print("  ");
                    }

                    if (i <= level3) {
                        System.out.print("\u25A0" + " ");
                    } else {
                        System.out.print("  ");
                    }

                    if (i <= level2) {
                        System.out.print("\u25A0" + " ");
                    } else {
                        System.out.print("  ");
                    }

                    if (i <= level1) {
                        System.out.println("\u25A0" + " ");
                    } else {
                        System.out.println("  ");
                    }

                }
                System.out.println("5 4 3 2 1");
                System.out.println("----------------------------------------------------------------------");
                break;

            //case 6 is searching for a song
            case "6":
                ArrayList<Integer> songIndex = new ArrayList<>();
                System.out.println("Searching:\nEnter the name of the artist, the name of the song, part of the name of the artist, or part of the name of the song ");
                String input = sc.nextLine().toLowerCase();
                for (int i = 0; i < names.size(); i ++) {
                    String current = names.get(i).toLowerCase();
                    if (current.contains(input)) {
                        songIndex.add(i);
                    }
                }

                for (int i = 0; i < artists.size(); i ++) {
                    String current = artists.get(i).toLowerCase();
                    if (current.contains(input)) {
                        songIndex.add(i);
                    }
                }
                if (songIndex.size() == 0) {
                    System.out.println("Song Not Found in the library");
                } else {
                    System.out.println("The song you might be searching is: ");
                    for (int i = 0; i < songIndex.size(); i++) {
                        System.out.println(names.get(songIndex.get(i)));
                        System.out.println(artists.get(songIndex.get(i)));
                        System.out.println(ratings.get(songIndex.get(i)));
                        System.out.println("----------------------------------------------------------------------");

                        if (ratings.get(i) > averageRating) {
                            System.out.println("The rating for this song is above the library average");
                        } else if (ratings.get(i) < averageRating) {
                            System.out.println("The rating for this song is below the library average");
                        } else {
                            System.out.println("The rating for this song is equals to the library average");
                        }
                    }
                }

                System.out.println("----------------------------------------------------------------------");
                break;
            //case 7 is display the top and bottom 20% songs
            case "7":
                ArrayList<Integer> reorderRating = new ArrayList<>();
                int numberOfSong20Percent = (int)((names.size())*0.2);
                ArrayList<Integer> testRatings = new ArrayList<>();
                for (int k = 0; k < ratings.size(); k ++) {
                    testRatings.add(ratings.get(k));
                }
                for (int i = 1; i <= ratings.size(); i ++) {
                    int smallestRating = Integer.MAX_VALUE;
                    int smallestRatingIndex = 0;
                    for (int j = 0; j < testRatings.size(); j++) {
                        int currentRating = testRatings.get(j);
                        if (currentRating < smallestRating) {
                            smallestRating = currentRating;
                            smallestRatingIndex = j;
                        }
                    }
                    reorderRating.add(smallestRating);
                    testRatings.remove(smallestRatingIndex);
                }
                System.out.println(reorderRating);
                System.out.println("the songs with the top 20% ratings are:");
                for (int j = names.size() - 1; j > names.size() - 1 - numberOfSong20Percent; j --) {
                    System.out.println(names.get(ratings.indexOf(reorderRating.get(j))));
                }

                System.out.println("the songs with the bottom 20% ratings are:");
                for (int j = 0; j < numberOfSong20Percent; j ++) {
                    System.out.println(names.get(ratings.indexOf(reorderRating.get(j))));
                }

                System.out.println("----------------------------------------------------------------------");
                break;
            //case 8 is Exit the program
            case "8":
                System.out.println("Thank you for using the MLM!");
                System.out.println("----------------------------------------------------------------------");
                loopCondition = false;
                break;
            //invalid input
            default:
                System.out.println("Invalid Input");
                System.out.println("----------------------------------------------------------------------");
                break;
        }

    }



}

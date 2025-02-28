import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz operację:");
            System.out.println("1 - Sortowanie");
            System.out.println("2 - Przeglądanie drzewa binarnego");
            System.out.println("q - Wyjście z programu");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("q")) {
                System.out.println("Zamykanie programu...");
                break;
            }

            switch (operation) {
                case "1":
                    while (true) {
                        System.out.println("Wybierz typ danych do sortowania:");
                        System.out.println("1 - Liczby całkowite | InsertionSort");
                        System.out.println("2 - Ciągi znaków | InsertionSort");
                        System.out.println("3 - Daty (yyyy-MM-dd) | InsertionSort");
                        System.out.println("4 - Liczby rzeczywiste | QuickSort");
                        System.out.println("0 - Powrót do menu głównego");

                        String choice = scanner.nextLine();
                        if (choice.equals("0")) break;

                        System.out.println("Podaj elementy do posortowania (oddzielone spacją):");
                        String input = scanner.nextLine();
                        System.out.println("Wybierz porządek sortowania: (1 - rosnąco, 2 - malejąco)");
                        boolean ascending = scanner.nextInt() == 1;
                        scanner.nextLine();

                        List<? extends Comparable<?>> list = null;
                        switch (choice) {
                            case "1": {
                                List<Integer> intList = new ArrayList<>();
                                for (String s : input.split(" ")) {
                                    intList.add(Integer.parseInt(s));
                                }
                                InsertionSort<Integer> sorter = new InsertionSort<>();
                                sorter.sort(intList, ascending);
                                list = intList;
                                break;
                            }
                            case "2": {
                                List<String> strList = new ArrayList<>(Arrays.asList(input.split(" ")));
                                InsertionSort<String> sorter = new InsertionSort<>();
                                sorter.sort(strList, ascending);
                                list = strList;
                                break;
                            }
                            case "3": {
                                List<Date> dateList = new ArrayList<>();
                                try {
                                    for (String s : input.split(" ")) {
                                        dateList.add(new SimpleDateFormat("yyyy-MM-dd").parse(s));
                                    }
                                } catch (Exception e) {
                                    System.out.println("Błąd parsowania daty!");
                                    continue;
                                }
                                InsertionSort<Date> sorter = new InsertionSort<>();
                                sorter.sort(dateList, ascending);
                                list = dateList;
                                break;
                            }
                            case "4": {
                                List<Double> doubleList = new ArrayList<>();
                                for (String s : input.split(" ")) {
                                    doubleList.add(Double.parseDouble(s));
                                }
                                QuickSort quickSort = new QuickSort();
                                quickSort.sort(doubleList, 0, doubleList.size() - 1);
                                if (!ascending) {
                                    Collections.reverse(doubleList);
                                }
                                list = doubleList;
                                break;
                            }
                            default:
                                System.out.println("Niepoprawny wybór!");
                                continue;
                        }
                        System.out.println("Posortowane elementy:");
                        list.forEach(System.out::println);
                    }
                    break;

                case "2":
                    while (true) {
                        BinaryTree tree = new BinaryTree();
                        System.out.println("Podaj liczby do dodania do drzewa (oddzielone spacją) lub wpisz 0, aby wrócić do menu głównego:");
                        String input = scanner.nextLine();
                        if (input.equals("0")) break;

                        for (String s : input.split(" ")) {
                            tree.insert(Integer.parseInt(s));
                        }

                        System.out.println("Wybierz sposób przeglądania drzewa:");
                        System.out.println("1 - In-order");
                        System.out.println("2 - Pre-order");
                        System.out.println("3 - Post-order");
                        System.out.println("0 - Powrót do menu głównego");

                        String traversalChoice = scanner.nextLine();
                        if (traversalChoice.equals("0")) break;

                        switch (traversalChoice) {
                            case "1":
                                System.out.println("Przeglądanie in-order:");
                                tree.inorder(tree.root);
                                break;
                            case "2":
                                System.out.println("Przeglądanie pre-order:");
                                tree.preorder(tree.root);
                                break;
                            case "3":
                                System.out.println("Przeglądanie post-order:");
                                tree.postorder(tree.root);
                                break;
                            default:
                                System.out.println("Niepoprawny wybór!");
                        }
                    }
                    break;

                default:
                    System.out.println("Niepoprawny wybór! Spróbuj ponownie.");
            }
        }
        scanner.close();
    }
}

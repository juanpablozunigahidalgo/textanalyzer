
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Word {

    // **Task 1** –
    //Design a class called **Word** that can be used to store details of a word that is read from a text file.
    //Apart from the word itself, the class should have an attribute to store the number of times the same word occurs in the file.
    //Define appropriate constructors and getter & setter methods for this class.

    static void getWords(String fileName,
                         Map<String, Integer> words)
            throws FileNotFoundException {
        // Creating a Scanner class object
        Scanner file = new Scanner(new File(fileName));

        // Condition check using hasNext() method which
        // holds true till there is word being read from the
        // file.
        // As the end of file content,condition violates
        while (file.hasNext()) {

            // Reading word using next() method
            String word = file.next();

            // Frequency count variable
            Integer count = words.get(word);

            // If the same word is repeating
            if (count != null) {

                // Incrementing corresponding count by unity
                // every time it repeats
                // while reading from the file
                count++;
            } else

                // If word never occurred after occurring
                // once, set count as unity
                count = 1;
            words.put(word, count);
        }

        // Close the file and free up the resources
        file.close();
    }

    // Method 2 - getMaxOccurrence()
    // To get maximum occurred Word
    static int getMaxOccurrence(Map<String, Integer> words) {
        // Initially set maximum count as unity
        int max = 1;

        // Iterating over above Map using for-each loop
        for (Entry<String, Integer> word :
                words.entrySet()) {

            // Condition check
            // Update current max value  with the value
            // exceeding unity in Map while traversing
            if (word.getValue() > max) {
                max = word.getValue();
            }
        }

        // Return the maximum value from the Map
        return max;
    }

    // **Task 2** –
    // This task involves reading a text file **/data/daffodils.txt** and creating a word list.
    // Your word list will consist of objects of the type **Word** defined in Task 1.
    // You should take care to ensure that no word is repeated in the list.
    // Instead, if a word that already exists in the list is found, simply increment the word count.
    // Once, you have read all the words in the file, use a method called **showWordList()** to show all the words that have been found
    // along with their frequency.

    static void showWordList(Map<String, Integer> words) {

        System.out.println(words);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // **Task 1** –
        Map<String, Integer> words = new HashMap<String, Integer>();
        //**Task 2** –
        getWords("C:\\Users....file.txt", words);
        //int max = getMaxOccurrence(words);
        // **Task 1** –&& **Task 2** – output here
        System.out.println("Word count frequency list. From the text. No order: ");
        showWordList(words);
        //**Task 3** – output here
        System.out.println("Word count frequency list. From the text. Alphabetical order: ");
        System.out.println(getTreeMap(words));
        //**Task 4** –output here
        System.out.println("Word count frequency list. From the text. Inverse alphabetical order: ");
        System.out.println(InverseOrder(words));
        //**Task 5** –output here
        System.out.println("Word count frequency list. From the text. Value order: ");
        System.out.println(showFrequentWords(words));


    }

    //**Task 3** –
    //Notice in the output displayed in Task 2, that the words are not shown in any specific order.
    //They are simply displayed in the order in which they were found in the file.
    //Now refactor your program so that the word list is constructed in such a way that the words are placed in alphabetical
    //order starting with the word “a” (if it exists in the file). Display this sorted word list.

    // I will do Task 3 with the bellow method.
    public static <K, V> Map<K, V> getTreeMap(Map<K, V> hashMap) throws FileNotFoundException {
        Map<String, Integer> wordst = new HashMap<String, Integer>();
        getWords("C:\\Users\\....file.txt", wordst);
        Map<K, V> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);
        return treeMap;
    }

    // I will do Task 4 with the bellow method.
    //**Task 4** – Write a method that shows the words in your word list in reverse alphabetical order.
    // In other words, you will need to begin with the last word in your list and display its details first. //
    // And then come backwards and show all the words in the reverse order.
    public static <K, V> Map<K, V> InverseOrder(Map<K, V> hashMap) throws FileNotFoundException {
        Map<String, Integer> wordstt = new HashMap<String, Integer>();
        getWords("C:\\Users\\....file.txt", wordstt);
        Map<K, V> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(hashMap);
        return treeMap;
    }
    //**Task 5** –
    //Write an additional method called **showFrequentWords()** that reads your alphabetically sorted
    // word list and displays the words in descending order of frequency.
    //i.e. the word with the highest frequency is listed first, then the word with the next highest
    //frequency, etc. If 2 words have the same frequency, they should be listed in alphabetical order.
    //I will do task 5 with the bellow method.

    public static <K, V extends Comparable<? super V>>SortedSet<Map.Entry<K, V>> showFrequentWords (Map < K, V > map){
            SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                    new Comparator<Map.Entry<K, V>>() {
                        @Override
                        public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                            int res = e2.getValue().compareTo(e1.getValue());
                            return res != 0 ? res : 1; // Special fix to preserve items with equal values
                        }
                    }
            );
            sortedEntries.addAll(map.entrySet());
            return sortedEntries;
        }

}









    //Task N5 does delete value =1. Solution not working bellow.

   //*public static Map sortByValue(Map unsortedMap) {
   //   Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
   //   sortedMap.putAll(unsortedMap);
  //    return sortedMap;
  //}


//}/*


//**Task 5** –
// This requires a class ValueComparator


       // class ValueComparator implements Comparator {
//            Map map;
//
//            public ValueComparator(Map map) {
//                this.map = map;
//            }
//
//            public int compare(Object keyA, Object keyB) {
//                Comparable valueA = (Comparable) map.get(keyA);
//                Comparable valueB = (Comparable) map.get(keyB);
//                return valueB.compareTo(valueA);
//            }
//        }


        // Traversing using fo-each loop
        // Creating a set out of same elements
        // contained in a HashMap
        // for (Entry<String, Integer> word :
        //         words.entrySet()) {
        //     System.out.println(word);
            // Comparing values using geValue() method
            //if (word.getValue() == max) {

                // Print and display word-count pair
               // System.out.println(word);
            //}



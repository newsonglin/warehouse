package com.lin.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class PredicateLearn {


    private boolean run() {
        List<String> strList = List.of("Li", "Song", "Lin", "", "Bei", "", "Li", "Lou");

        Predicate<String> noEmpty = s -> s != null && !s.isEmpty();
        List<String> filterEmptyList = filterListV2(strList, noEmpty);
        System.out.println(filterEmptyList);

        List<String> filterContainList = filterListV2(strList, s -> s.contains("Li"));
        System.out.println(filterContainList);


        List<Integer> intList=List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evens=filterListV2(intList,i->i%2==0);
        System.out.println(evens);



        return true;

    }


    /**
     * Version two of filter list with generic
     * @param list the list to be filtered
     * @param match predicate
     * @return filtered list
     */
    private <T> List<T> filterListV2(List<T> list, Predicate<T> match) {
        List<T> filterList = new ArrayList<>();
        for (T element : list) {
            if (match.test(element)) {
                filterList.add(element);
            }

        }
        return  filterList;
    }

    /**
     * Version one of filter list without generic
     * @param list the list to be filtered
     * @param match predicate
     * @return filtered list
     */
    private List<String> filterListV1(List<String> list, Predicate<String> match) {
        List<String> filterList = new ArrayList<>();
        for (String element : list) {
            if (match.test(element)) {
                filterList.add(element);
            }

        }
        return  filterList;
    }

    public static void main(String[] args) {
        PredicateLearn predicateLearn = new PredicateLearn();
        System.out.println(predicateLearn.run());

    }


}

package com.swamwithturtles.expenses;

import static com.swamwithturtles.common.StreamUtils.cartesianProduct;
import com.swamwithturtles.common.datastructure.IntPair;
import com.swamwithturtles.common.datastructure.IntTriple;
import com.swamwithturtles.common.datastructure.Arithmeticable;
import java.util.Set;

public class Expenses {

    private final Set<Integer> expenseValues;

    public Expenses(Set<Integer> expenseValues) {
        this.expenseValues = expenseValues;
    }

    public Integer findProductOfTwoExpenses() {
        IntPair matchingExpense = cartesianProduct(expenseValues, expenseValues)
                .stream()
                .map(IntPair::from)
                .filter(this::isMatchingExpense)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching expenses"));

        return matchingExpense.product();
    }

    public Integer findProductOfThreeExpenses() {
        IntTriple matchingExpense = cartesianProduct(expenseValues, expenseValues, expenseValues)
                .stream()
                .map(IntTriple::from)
                .filter(this::isMatchingExpense)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching expenses"));

        return matchingExpense.product();
    }

    private boolean isMatchingExpense(Arithmeticable expense) {
        return expense.sum() == 2020;
    }
}

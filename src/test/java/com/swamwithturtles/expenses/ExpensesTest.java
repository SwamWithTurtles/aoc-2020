package com.swamwithturtles.expenses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ExpensesTest {

    @Test
    public void worksWithSimpleCaseForTwoExpenses() {
        Set<Integer> expenses = new HashSet<>();
        expenses.addAll(Arrays.asList(1, 2019));

        Expenses expensesObject = new Expenses(expenses);

        assertThat(expensesObject.findProductOfTwoExpenses()).isEqualTo(2019);
    }

    @Test
    public void worksWithManyExpensesForTwoExpenses() {
        Set<Integer> expenses = new HashSet<>();
        expenses.addAll(Arrays.asList(4, 4, 4, 4, 4, 4, 2, 2018));

        Expenses expensesObject = new Expenses(expenses);

        assertThat(expensesObject.findProductOfTwoExpenses()).isEqualTo(2 * 2018);
    }

    @Test
    public void worksWithSimpleCaseForThreeExpenses() {
        Set<Integer> expenses = new HashSet<>();
        expenses.addAll(Arrays.asList(1, 1, 2018));

        Expenses expensesObject = new Expenses(expenses);

        assertThat(expensesObject.findProductOfThreeExpenses()).isEqualTo(2018);
    }

    @Test
    public void worksWithManyExpensesForThreeExpenses() {
        Set<Integer> expenses = new HashSet<>();
        expenses.addAll(Arrays.asList(4, 4, 4, 4, 4, 4, 2, 2, 2016));

        Expenses expensesObject = new Expenses(expenses);

        assertThat(expensesObject.findProductOfThreeExpenses()).isEqualTo(2 * 2 * 2016);
    }
}

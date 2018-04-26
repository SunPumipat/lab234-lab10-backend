package camt.se234.lab10.service;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class GradeServiceImplTest {
    @Test
    public void testGetGrade() {
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(100), is("A"));
        assertThat(gradeService.getGrade(80), is("A"));
        assertThat(gradeService.getGrade(78.9), is("B"));
        assertThat(gradeService.getGrade(75), is("B"));
        assertThat(gradeService.getGrade(74.4), is("C"));
        assertThat(gradeService.getGrade(60), is("C"));
        assertThat(gradeService.getGrade(59.4), is("D"));
        assertThat(gradeService.getGrade(33), is("D"));
        assertThat(gradeService.getGrade(32), is("F"));
        assertThat(gradeService.getGrade(0), is("F"));
    }

    @Test
    @Parameters(method = "paramsForTestGetGradeParams")
    @TestCaseName("Test getGrade Params [{index}] : input is {0}, expect \"{1}\"")
    public void testGatGradeparams(double score, String expectedGrade) {
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(score), is(expectedGrade));
    }

    public Object paramsForTestGetGradeParams() {
        return new Object[][]{
                {100, "A"},
                {77, "B"},
                {68, "C"},
                {55, "D"},
                {0, "F"}
        };
    }

    @Test
    @Parameters(method = "paramMidtermAndFinal")
    @TestCaseName("Test getGradeSummationScore Params [{index}] : input is {0}, expect \"{1}\"")
    public void testgetGradeSummationScore(double midtermScore , double finalScore , String expectedGrade){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(midtermScore,finalScore), is(expectedGrade));
    }

    public Object paramMidtermAndFinal(){
        return new Object[][]{
                {10 , 20 ,"F"},
                {20 , 30 ,"D"},
                {30 , 30 ,"C"},
                {40 , 30 ,"B"},
                {80 , 15 , "A"}
        };
    }
}

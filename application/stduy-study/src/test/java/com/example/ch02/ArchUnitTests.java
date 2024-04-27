package com.example.ch02;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.example.stduy.ch02")
public class ArchUnitTests {

    @ArchTest
    public static final ArchRule 컨트롤러는_서비스만_접근이_가능하다 =
            classes().that().resideInAnyPackage("..controller..")
                    .should().accessClassesThat().resideInAnyPackage("..service..");

    @ArchTest
    public static final ArchRule 서비스는_리포지토리패키지는_접근이_불가능하다 =
            noClasses().that().resideInAPackage("..controller..")
                    .should().accessClassesThat().resideInAPackage("..repository..");

    @ArchTest
    public static final ArchRule controller_접미사_붙은_클래스느_컨트롤러_패키지에_존재해야한다 =
            classes().that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("..controller..");

}

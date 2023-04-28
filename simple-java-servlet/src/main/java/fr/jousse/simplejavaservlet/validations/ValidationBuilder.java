package fr.jousse.simplejavaservlet.validations;

import io.github.classgraph.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidationBuilder {
  public static LoginValidation build() {

    Map<Integer, Class> validationClasses = new HashMap<>();

    String pkg = "fr.jousse.simplejavaservlet.validations";
    String routeAnnotation = pkg + ".LoginValidationAnnotation";
    try (ScanResult scanResult =
                 new ClassGraph()
                         .verbose()               // Log to stderr
                         .enableAllInfo()         // Scan classes, methods, fields, annotations
                         .acceptPackages(pkg)     // Scan com.xyz and subpackages (omit to scan all packages)
                         .scan()) {               // Start the scan
      for (ClassInfo routeClassInfo : scanResult.getClassesWithAnnotation(routeAnnotation)) {
        
        System.out.println(routeClassInfo.getName());

        try{
        routeClassInfo.getClass().newInstance();
        }catch (Exception e) {
          e.printStackTrace();
        }

        AnnotationInfo routeAnnotationInfo = routeClassInfo.getAnnotationInfo(routeAnnotation);

        List<AnnotationParameterValue> routeParamVals = routeAnnotationInfo.getParameterValues();
        validationClasses.put((Integer) routeParamVals.get(0).getValue(), routeClassInfo.getClass());
      }


      List<LoginValidation> validationList = validationClasses
              .entrySet()
              .stream()
              .sorted((o1, o2) -> (o2.getKey() - o1.getKey()))
              .map(Map.Entry::getValue)
              .map(aClass -> {
                        try {
                          System.out.println(aClass.getClass().getName());
                          return (LoginValidation) aClass.newInstance();
                        } catch (Exception e) {
                          e.printStackTrace();
                          throw new RuntimeException(e);
                        }}).collect(Collectors.toList());

      return validationList.get(0);
    }

    /* old style
    AccountNotConfirmedLoginValidation accountNotConfirmedLoginValidation =
        new AccountNotConfirmedLoginValidation();
    InDatabaseLoginValidation inDatabaseLoginValidation = new InDatabaseLoginValidation();
    UserPasswordLoginValidation userPasswordLoginValidation = new UserPasswordLoginValidation();

      accountNotConfirmedLoginValidation.setNext(inDatabaseLoginValidation);
      inDatabaseLoginValidation.setNext(userPasswordLoginValidation);

      return accountNotConfirmedLoginValidation;

     */
  }
}

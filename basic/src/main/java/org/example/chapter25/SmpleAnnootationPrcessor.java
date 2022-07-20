package org.example.chapter25;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes({"org.example.chapter25.SimpleField"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SmpleAnnootationPrcessor implements Processor {

    @Override
    public Set<String> getSupportedOptions() {
        return null;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return null;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return null;
    }

    @Override
    public void init(ProcessingEnvironment processingEnv) {

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        for (TypeElement t  : annotations) {
//            System.out.println(t);
//        }
//        for (Element element : roundEnv.getElementsAnnotatedWith(SimpleField.class)) {
//            System.out.println(element.getSimpleName());
//            System.out.println(element.getKind());
//        }
        return false;
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return null;
    }
}

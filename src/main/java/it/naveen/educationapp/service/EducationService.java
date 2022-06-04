package it.naveen.educationapp.service;

public interface EducationService<I, O> {
    O process(I input);
}

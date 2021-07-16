package com.bae.service;

import com.bae.request.test.Patient;

import java.util.concurrent.ExecutionException;

/**
 * date 2021-03-24 11:22
 *
 * @author Phạm Ngọc Thắng
 */
public interface PatientService {
    Patient getPatientDetails(String name) throws InterruptedException, ExecutionException;

    String savePatientDetails(Patient patient) throws InterruptedException, ExecutionException;

    String updatePatientDetails(Patient patient) throws InterruptedException, ExecutionException;

    String deletePatient(String name);
}
